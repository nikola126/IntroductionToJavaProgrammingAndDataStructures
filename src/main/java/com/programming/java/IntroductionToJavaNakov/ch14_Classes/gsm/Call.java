package com.programming.java.IntroductionToJavaNakov.ch14_Classes.gsm;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Call {
    private Date date;
    private Date callStart;
    private long durationMs;
}
