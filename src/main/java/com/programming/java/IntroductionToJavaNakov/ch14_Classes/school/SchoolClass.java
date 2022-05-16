package com.programming.java.IntroductionToJavaNakov.ch14_Classes.school;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SchoolClass {
    private List<Teacher> teachers = new ArrayList<>();
    private long id;
}
