package com.programming.java.IntroductionToJavaNakov.ch14_Classes.school;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Discipline {
    private String name;
    private int lessonCount;
    private int exerciseCount;
}
