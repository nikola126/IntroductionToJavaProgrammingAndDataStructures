package com.programming.java.LaLigaBetTask.Classes;

import java.util.Comparator;
import java.util.Map;

// used by the streak map in Task 3 to keep descending streak order
public class CustomStreakComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
        return (-1) * Integer.compare(o1.getValue(), o2.getValue());
    }
}
