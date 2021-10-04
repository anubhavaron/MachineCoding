package com.test.sl.dao;

import com.test.sl.model.Board;
import com.test.sl.model.GameStatus;
import lombok.Getter;
import lombok.Setter;

public class GameDao {

    @Getter
    private Board board;

    @Getter
    @Setter
    private GameStatus gameStatus;

    public GameDao(Board board) {
        this.board = board;
        this.gameStatus = GameStatus.NOT_STARTED;
    }
}
