package com.machinecoding.cricinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Player {
    private String name;
    private String playerId;
    private PlayerStats playerStats;
}
