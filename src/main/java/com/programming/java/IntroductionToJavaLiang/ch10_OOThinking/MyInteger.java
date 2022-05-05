package com.programming.java.IntroductionToJavaLiang.ch10_OOThinking;

public class MyInteger {
    private final int value;

    public MyInteger(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public boolean isEven() {
        return (value % 2 == 0);
    }

    public boolean isOdd() {
        return (value % 2 != 0);
    }

    public boolean isPrime() {
        for (int i = 2; i < value / 2; i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isEven(int value) {
        return (value % 2 == 0);
    }

    public static boolean isOdd(int value) {
        return (value % 2 != 0);
    }

    public static boolean isPrime(int value) {
        for (int i = 2; i < value / 2; i++) {
            if (value % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isEven(MyInteger myInteger) {
        return (myInteger.getValue() % 2 == 0);
    }

    public static boolean isOdd(MyInteger myInteger) {
        return (myInteger.getValue() % 2 != 0);
    }

    public static boolean isPrime(MyInteger myInteger) {
        for (int i = 2; i < myInteger.getValue() / 2; i++) {
            if (myInteger.getValue() % i == 0)
                return false;
        }
        return true;
    }

    public boolean equals(int value) {
        return (this.value == value);
    }

    public boolean equals(MyInteger myInteger) {
        return (this.value == myInteger.getValue());
    }

    public static int parseInt(char[] array) {
        return Integer.parseInt(String.copyValueOf(array));
    }

    public static int parseInt(String string) {
        return Integer.parseInt(string);
    }
}
