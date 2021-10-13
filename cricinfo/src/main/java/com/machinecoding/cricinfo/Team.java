package com.machinecoding.cricinfo;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;

@Data
@AllArgsConstructor
public class Team {
    private ArrayList<Player> playerList;
    private String teamName;
    private int teamId;
}
