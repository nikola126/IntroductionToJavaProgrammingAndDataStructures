package com.programming.java.chapter12.customExceptions;

public class IllegalTriangleException extends Exception{
    public IllegalTriangleException(String message) {
        super(message);
    }
}
