package com.machinecoding.cricinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@AllArgsConstructor
public abstract class User {
    private String name;
    @Setter
    private AccountStatus accountStatus;

    abstract UserType getUserType();
}
