package com.programming.java.IntroductionToJavaNakov.ch14_Classes.school;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {
    private String name;
    private List<Discipline> disciplines = new ArrayList<>();
}
