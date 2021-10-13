package com.machinecoding.cricinfo;

import java.util.ArrayList;

public class Admin extends User{

    private StatsDao statsDao;

    public Admin(String name, AccountStatus accountStatus, StatsDao statsDao) {
        super(name, accountStatus);
        this.statsDao = statsDao;
    }

    @Override
    public UserType getUserType() {
        return UserType.ADMIN;
    }

    public Team registerTeam(String teamName, ArrayList<Player> players) {
        Team team = new Team(players, teamName, TeamIdResolver.getTeamId());
        statsDao.getTeamMap().put(team.getTeamId(), team);
        return team;
    }


}
