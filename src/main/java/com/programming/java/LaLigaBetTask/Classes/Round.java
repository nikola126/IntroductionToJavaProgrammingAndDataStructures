package com.programming.java.LaLigaBetTask.Classes;

import lombok.Data;

import java.util.List;

@Data
public class Round {
    private int number;
    private List<Game> gameList;
}
