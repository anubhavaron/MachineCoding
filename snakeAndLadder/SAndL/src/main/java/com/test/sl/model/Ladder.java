package com.test.sl.model;

import lombok.Getter;

public class Ladder {

    @Getter
    private int start;
    @Getter
    private int end;

    public Ladder(int start, int end) {
        this.start = start;
        this.end = end;
    }

}
