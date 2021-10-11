package com.coding.library.model;

import lombok.Getter;

public class Rack {

    @Getter
    private final Integer rackId;

    public Rack(Integer rackId) {
        this.rackId = rackId;
    }
}
