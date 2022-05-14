package com.programming.java.IntroductionToJavaNakov.ch11_Objects;

import com.programming.java.IntroductionToJavaNakov.ch11_Objects.examples.Example;

import java.util.Random;
import java.util.Scanner;

public class ChapterEleven {
    public static void taskOne() {
        long totalMilliseconds = System.currentTimeMillis();
        long totalSeconds = totalMilliseconds / 1000;
        long totalMinutes = totalSeconds / 60;
        long totalHours = totalMinutes / 60;
        long totalDays = totalHours / 24;

        System.out.println("Days since 1.Jan 1970: " + totalDays);
        System.out.println("Hours since 1.Jan 1970: " + totalHours);
        System.out.println("Minutes since 1.Jan 1970: " + totalMinutes);
    }

    public static void taskTwo() {
        Scanner scanner = new Scanner(System.in);
        double sideA, sideB, sideC;

        System.out.print("Enter side A: ");
        sideA = scanner.nextDouble();
        System.out.print("Enter side B: ");
        sideB = scanner.nextDouble();

        sideC = Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
        System.out.println("Hypotenuse: " + sideC);
    }

    public static void taskThree() {
        Example.example();
    }

    public static void taskFour() {
        Cat[] cats = new Cat[10];
        for (int i = 0; i < 10; i++) {
            cats[i] = new Cat("Cat" + i, "brown");
        }

        for (Cat cat : cats)
            cat.sayMiau();
    }

    public static void taskFive() {
        String[] phrases = new String[]{"Produktat e otlichen!",
                "Tova e strahoten produkt!", "Postoqnno polzvam tozi produkt.",
                "Tova e nai-dobriyat produkt ot tazi kategoriq!"};
        String[] events = new String[]{"Veche se chuvstvam dobre.", "Uspqx da se promenq!," +
                "Toi napravi chudo!", "Ne moga da povqrvam, no veche se chustvam strahotno.",
                "Opitaite i vie. Az sum mnogo dovolna!"};
        String[] firstNames = new String[]{"Diana", "Petya", "Stela", "Elena", "Katya"};
        String[] lastNames = new String[]{"Ivanova", "Petrova", "Kirova"};
        String[] cities = new String[]{"Sofia", "Plovdiv", "Varna", "Ruse", "Burgas"};

        Random random = new Random();
        System.out.println(phrases[random.nextInt(0, phrases.length)] + " " + events[random.nextInt(0, events.length)]);
        System.out.print(" - " + firstNames[random.nextInt(0, firstNames.length)] + " " + lastNames[random.nextInt(0, lastNames.length)]);
        System.out.println(", " + cities[random.nextInt(0, cities.length)]);
    }

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
    }
}
