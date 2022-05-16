package com.programming.java.IntroductionToJavaNakov.ch14_Classes.gsm;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Battery {
    private String mode;
    private long idleTime;
    private long talkTime;
}
