package com.coding.library.model;

import lombok.Getter;

public class User {

    @Getter
    private final String name;

    @Getter
    private final String id;

    public User(String name, String id) {
        this.name = name;
        this.id = id;
    }
}
