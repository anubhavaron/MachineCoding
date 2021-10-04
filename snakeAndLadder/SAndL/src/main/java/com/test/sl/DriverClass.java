package com.test.sl;

import com.test.sl.dao.GameDao;
import com.test.sl.model.Board;
import com.test.sl.model.DiceStrategy;
import com.test.sl.model.Player;
import com.test.sl.service.SnakeAndLadderGame;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DriverClass {

    public static void main(String[] args) {
        Map<Integer, Integer> snakeMap = new HashMap<>();
        snakeMap.put(40, 10);
        snakeMap.put(30, 10);
        snakeMap.put(20, 10);
        snakeMap.put(50, 10);
        snakeMap.put(60, 10);
        Map<Integer, Integer> ladderMap = new HashMap<>();
        ladderMap.put(45, 90);
        ladderMap.put(35, 90);
        ladderMap.put(25, 90);
        ladderMap.put(55, 90);
        ladderMap.put(65, 90);
        Board board = new Board(snakeMap, ladderMap, 100);
        GameDao gameDao = new GameDao(board);
        SnakeAndLadderGame snakeAndLadderGame = new SnakeAndLadderGame(gameDao, DiceStrategy.SINGLE_DICE,
                Arrays.asList(new Player("Anu"), new Player("Azeem")));
        snakeAndLadderGame.startGame();
    }
}
