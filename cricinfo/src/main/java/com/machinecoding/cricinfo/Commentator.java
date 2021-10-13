package com.machinecoding.cricinfo;

public class Commentator extends User{

    public Commentator(String name, AccountStatus accountStatus) {
        super(name, accountStatus);
    }

    @Override
    UserType getUserType() {
        return UserType.COMMENTATOR;
    }
}
