package com.machinecoding.splitwise.model;
import lombok.Getter;

public class User {
    @Getter
    private String name;
    @Getter
    private String email;
    @Getter
    private String phoneNumber;
    @Getter
    private Integer userId;

    public User(String name, String email, String phoneNumber, Integer userId) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.userId = userId;
    }
}
