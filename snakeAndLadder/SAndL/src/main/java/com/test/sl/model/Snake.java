package com.test.sl.model;

import lombok.Getter;

public class Snake {
    @Getter
    private int head;
    @Getter
    private int tail;

    public Snake(int head, int tail) {
        this.head = head;
        this.tail = tail;
    }
}
