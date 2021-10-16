package com.anubhav.library.model;

import lombok.Getter;

@Getter
public class Rack {
    private  final Integer rackNumber;

    public Rack(Integer rackNumber) {
        this.rackNumber = rackNumber;
    }
}
