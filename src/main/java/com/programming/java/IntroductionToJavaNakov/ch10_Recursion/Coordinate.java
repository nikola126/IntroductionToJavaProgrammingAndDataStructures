package com.programming.java.IntroductionToJavaNakov.ch10_Recursion;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Coordinate {
    private int x;
    private int y;
    private Coordinate parent;

    @Override
    public String toString() {
        return "[" + x + "," + y + "]";
    }
}
