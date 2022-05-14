package com.programming.java.IntroductionToJavaNakov.ch11_Objects.examples;

import com.programming.java.IntroductionToJavaNakov.ch11_Objects.Cat;
import com.programming.java.IntroductionToJavaNakov.ch11_Objects.Sequence;

public class Example {
    public static void example() {
        Cat cat1 = new Cat("Georgi", "black");
        Cat cat2 = new Cat("Irina", "white");

        System.out.println("This sequence has " + Sequence.nextValue() + " values.");
        System.out.println("Now it has " + Sequence.nextValue() + ".");

        cat1.sayMiau();
        cat2.sayMiau();
    }
}
