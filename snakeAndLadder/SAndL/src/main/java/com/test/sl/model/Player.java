package com.test.sl.model;

import lombok.Getter;
import lombok.Setter;

public class Player {

    @Getter
    private String playerName;

    @Getter
    @Setter
    private PlayerStatus playerStatus = PlayerStatus.ONLINE;

    public Player(String playerName) {
        this.playerName = playerName;
    }
}
