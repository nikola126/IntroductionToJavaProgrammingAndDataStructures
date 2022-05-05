package com.programming.java.IntroductionToJavaLiang.ch12_ExceptionHandlingTextIO.customExceptions;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String message) {
        super(message);
    }
}
