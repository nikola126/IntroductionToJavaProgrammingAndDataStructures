package com.programming.java.LaLigaBetTask;

import java.util.Comparator;

public class CustomTeamComparator implements Comparator<Team> {
    public int compare(Team o1, Team o2) {
        int comparison = o1.getName().compareTo(o2.getName());
        return Integer.compare(comparison, 0);
    }
}
