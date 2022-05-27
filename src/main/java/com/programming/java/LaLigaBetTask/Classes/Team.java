package com.programming.java.LaLigaBetTask.Classes;

import lombok.Data;

@Data
public class Team {
    private String name;
    private int gamesPlayed;
    private int homeWins;
    private int awayWins;
    private int draws;

    @Override
    public String toString() {
        // TODO Remove
        StringBuilder sb = new StringBuilder();
        sb.append(name + " ");
        sb.append("Games: " + gamesPlayed + " ");
        sb.append("Home: " + homeWins + " ");
        sb.append("Away: " + awayWins + " ");
        sb.append("Draw: " + draws + " ");
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int hashCode() {
        // TODO Use hash of team name too?
        final int prime = 31;
        int result = 1;
        result = prime * result + this.gamesPlayed;
        result = prime * result + this.homeWins;
        result = prime * result + this.awayWins;
        result = prime * result + this.draws;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        Team team;

        try {
            team = (Team) obj;
        } catch (ClassCastException e) {
            return false;
        }

        return this.name.equals(team.getName()) &&
                this.gamesPlayed == team.getGamesPlayed() &&
                this.homeWins == team.getHomeWins() &&
                this.awayWins == team.getAwayWins() &&
                this.draws == team.getDraws();
    }
}
