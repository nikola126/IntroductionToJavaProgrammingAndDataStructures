package com.programming.java.IntroductionToJavaNakov.ch14_Classes.school;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class School {
    List<Discipline> disciplineList = new ArrayList<>();
    List<Student> studentList = new ArrayList<>();
}
