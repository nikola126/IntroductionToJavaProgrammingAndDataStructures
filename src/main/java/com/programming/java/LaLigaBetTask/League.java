package com.programming.java.LaLigaBetTask;

import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
public class League {
    private String name;
    private LocalDate startYear;
    private LocalDate endYear;
    private Set<Team> teams; // can be TreeSet comparable by name
    private List<Round> rounds;
}
