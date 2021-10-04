package com.test.sl.model;

import lombok.Getter;

import java.util.Map;

public class Board {
    @Getter
    private Map<Integer, Integer > snakeHeadToTailMap;
    @Getter
    private Map<Integer, Integer> ladderStartToEndMap;
    @Getter
    private int cells;

    public Board(Map<Integer, Integer> snakeHeadToTailMap, Map<Integer, Integer> ladderStartToEndMap, int cells) {
        this.snakeHeadToTailMap = snakeHeadToTailMap;
        this.ladderStartToEndMap = ladderStartToEndMap;
        this.cells = cells;
    }
}
