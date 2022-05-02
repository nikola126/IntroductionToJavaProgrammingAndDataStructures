package com.programming.java.chapter10;

import java.util.Calendar;

public class MyDate {
    private int day;
    private int month;
    private int year;

    public MyDate() {
        Calendar now = Calendar.getInstance();
        day = now.get(Calendar.DAY_OF_MONTH);
        month = now.get(Calendar.MONTH);
        year = now.get(Calendar.YEAR);
    }

    public MyDate(long millis) {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(millis);
        day = now.get(Calendar.DAY_OF_MONTH);
        month = now.get(Calendar.MONTH);
        year = now.get(Calendar.YEAR);
    }

    public MyDate(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public void setDate(long elapsedTime) {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(elapsedTime);
        day = now.get(Calendar.DAY_OF_MONTH);
        month = now.get(Calendar.MONTH);
        year = now.get(Calendar.YEAR);
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "MyDate{" +
                "day=" + day +
                ", month=" + month +
                ", year=" + year +
                '}';
    }
}
