package com.machinecoding.cricinfo;

public class TeamIdResolver {
    public static int teamId = 0;
    public  static int getTeamId() {
        teamId++;
        return teamId;
    }
}
