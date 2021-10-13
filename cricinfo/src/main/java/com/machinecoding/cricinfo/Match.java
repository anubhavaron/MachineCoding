package com.machinecoding.cricinfo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Map;

@AllArgsConstructor
@Getter
public class Match {
    private String matchNo;
    private Team team1;
    private Team team2;
    private ArrayList<BallCommentary> ballCommentaries;
    private Referee referee;
    private MatchType matchType;
    private Map<Player, PlayerStats> playerPlayerStatsMap;
}
