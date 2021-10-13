package com.machinecoding.cricinfo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Map;

@Getter
@Setter
public class StatsDao {
    public Map<MatchType, ArrayList<Match>> matchTypeArrayListMap;
    public Map<String, Player> playerMap;
    public Map<String, Tournament> tournamentMap;
    public Map<Integer, Team> teamMap;
}
