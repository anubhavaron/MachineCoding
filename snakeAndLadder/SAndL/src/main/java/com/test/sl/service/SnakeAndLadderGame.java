package com.test.sl.service;

import com.test.sl.constants.GameConstants;
import com.test.sl.dao.GameDao;
import com.test.sl.model.*;
import javafx.util.Pair;
import lombok.Getter;


import java.util.*;
public class SnakeAndLadderGame {
    @Getter
    GameDao gameDao;

    @Getter
    private DiceRollingService diceRollingService;

    private Queue<Pair<Player, Integer>> activePlayerQueuePos = new LinkedList<>();

    public SnakeAndLadderGame(GameDao gameDao, DiceStrategy diceStrategy, List<Player> playerList) {
        this.gameDao = gameDao;
        diceRollingService = DiceServiceGetter.getDiceSRollingService(diceStrategy);
        initialisePlayersInQueue(playerList);
    }

    private void initialisePlayersInQueue(List<Player> playerList) {
        for(Player player : playerList) {
            activePlayerQueuePos.offer(new Pair<>(player, GameConstants.startingPlayerPosition));
        }
    }

    public void startGame() {
        gameDao.setGameStatus(GameStatus.IN_PROGRESS);
        progressGameTillFinish();
    }

    private void progressGameTillFinish() {
        while(!isGameFinished()) {
            Pair<Player, Integer> playerInfo = getNextPlayerInfo();
            if(isPlayerOffline(playerInfo)) {
                removePlayerFromActiveList();
            } else {
                Integer newPos =  getNextPositionOfPlayer(playerInfo) ;
                System.out.println(newPos + ": Pos");
                updateActivePlayerQueue(playerInfo, newPos);
                if(newPos == gameDao.getBoard().getCells()) {
                    System.out.println(playerInfo.getKey().getPlayerName() + " reached and Wins");
                    gameDao.setGameStatus(GameStatus.FINISHED);
                }
            }
            if(activePlayerQueuePos.size() == 1) {
                System.out.println("Only One Player Left");
                gameDao.setGameStatus(GameStatus.FINISHED);
            }
        }
    }

    private boolean isPlayerOffline(Pair<Player, Integer> playerInfo) {
        return playerInfo.getKey().getPlayerStatus()==PlayerStatus.OFFLINE;
    }

    private boolean isGameFinished() {
        return (gameDao.getGameStatus() == GameStatus.FINISHED);
    }

    private void updateActivePlayerQueue(Pair<Player, Integer> playerInfo, Integer newPos) {
        removePlayerFromActiveList();
        Pair<Player, Integer> playerIntegerPair = new Pair<>(playerInfo.getKey(), newPos);
        activePlayerQueuePos.offer(playerIntegerPair);
    }

    private Integer getNextPositionOfPlayer(Pair<Player, Integer> player) {
        Integer currentPosition = player.getValue();
        int totalSix = 0;
        while(totalSix <= 3) {
            Integer rollDiceNumber = diceRollingService.getRollingNumber();
            System.out.println("Rolled "+ rollDiceNumber);
            if(rollDiceNumber != 6) {
               currentPosition += rollDiceNumber;
               currentPosition = updateOrderWithSnakesAndLadder(currentPosition);
               if(currentPosition > gameDao.getBoard().getCells()) {
                   System.out.println("OUT OF BOARD");
                   return player.getValue();
               }

               return currentPosition;
            } else {
                currentPosition += rollDiceNumber;
                currentPosition = updateOrderWithSnakesAndLadder(currentPosition);
                if(currentPosition > gameDao.getBoard().getCells()) {
                    System.out.println("OUT OF BOARD");
                    return player.getValue();
                }
                totalSix++;
            }

        }
        System.out.println("3 SIXES: CHANCE REVOKED");
        return player.getValue();
    }

    private void removePlayerFromActiveList() {
         activePlayerQueuePos.poll();
    }

    private Pair<Player, Integer> getNextPlayerInfo() {
        System.out.println(activePlayerQueuePos.peek().getKey().getPlayerName() + ": Next Player");
        System.out.println(activePlayerQueuePos.peek().getValue() + ": Curr pos ");
        return activePlayerQueuePos.peek();
    }

    private Integer updateOrderWithSnakesAndLadder(Integer pos) {
        while(Objects.nonNull(gameDao.getBoard().getSnakeHeadToTailMap().get(pos)) || Objects.nonNull(gameDao.getBoard().getLadderStartToEndMap().get(pos))) {
            if(Objects.nonNull(gameDao.getBoard().getSnakeHeadToTailMap().get(pos))) {
                pos = gameDao.getBoard().getSnakeHeadToTailMap().get(pos);
            } else {
                pos = gameDao.getBoard().getLadderStartToEndMap().get(pos);
            }
        }
        return pos;
    }
}
