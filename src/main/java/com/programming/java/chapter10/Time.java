package com.programming.java.chapter10;

import java.util.Calendar;
import java.util.Date;

public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time() {
        Calendar now = Calendar.getInstance();
        hour = now.get(Calendar.HOUR_OF_DAY);
        minute = now.get(Calendar.MINUTE);
        second = now.get(Calendar.SECOND);
    }

    public Time(long millis) {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(millis);
        hour = now.get(Calendar.HOUR_OF_DAY);
        minute = now.get(Calendar.MINUTE);
        second = now.get(Calendar.SECOND);
    }

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void setTime(long elapsedTime) {
        Calendar now = Calendar.getInstance();
        now.setTimeInMillis(elapsedTime);
        hour = now.get(Calendar.HOUR_OF_DAY);
        minute = now.get(Calendar.MINUTE);
        second = now.get(Calendar.SECOND);
    }

}
