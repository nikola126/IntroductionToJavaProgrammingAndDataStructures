package com.programming.java.LaLigaBetTask;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Game {
    private String nameTeamHome;
    private String nameTeamAway;
    private int scoreTeamHome;
    private int scoreTeamAway;
    private double odds1;
    private double oddsX;
    private double odds2;
    private LocalDate gameDate;
    private GameResult gameResult;

    @Override
    public String toString() {
        // TODO Remove
        StringBuilder sb = new StringBuilder();
        sb.append(nameTeamHome).append(" - ").append(nameTeamAway);
        sb.append(" ");
        sb.append(scoreTeamHome).append(":").append(scoreTeamAway);
        sb.append(" ");
        sb.append(gameResult);
        sb.append(" [");
        sb.append(odds1).append(" ").append(oddsX).append(" ").append(odds2);
        sb.append("] ");
        sb.append(gameDate.toString()).append("\n");

        return sb.toString();
    }
}
