package com.programming.java.IntroductionToJavaLiang.ch9_ObjectsAndClasses;

public class Stopwatch {
    private long startTime;
    private long endTime;

    public Stopwatch() {
        this.startTime = System.currentTimeMillis();
    }

    public void start() {
        this.startTime = System.currentTimeMillis();
    }

    public void stop() {
        this.endTime = System.currentTimeMillis();
    }

    public long getElapsedTime() {
        return endTime - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public long getEndTime() {
        return endTime;
    }
}
