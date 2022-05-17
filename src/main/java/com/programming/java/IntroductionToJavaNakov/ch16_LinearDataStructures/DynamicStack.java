package com.programming.java.IntroductionToJavaNakov.ch16_LinearDataStructures;

import java.util.Arrays;

public class DynamicStack {
    private int capacity;
    private int size;
    private Object[] objects;

    public DynamicStack() {
        this.capacity = 5;
        size = 0;
        objects = new Object[this.capacity];
    }

    public void push(Object object) {
        // resize if needed
        if (size >= capacity) {
            capacity = capacity * 2;
            objects = Arrays.copyOf(objects, capacity * 2);
        }
        objects[size] = object;
        size += 1;
    }

    public Object pop() {
        if (size == 0)
            throw new NullPointerException("Stack is empty!");

        Object popped = objects[size - 1];
        objects[size - 1] = null;
        size--;
        return popped;
    }

    public Object peek() {
        if (size == 0)
            throw new NullPointerException("Stack is empty!");

        return objects[size - 1];
    }
}
