package com.programming.java.IntroductionToJavaNakov.ch16_LinearDataStructures;

import java.util.Arrays;

public class MyQueue {
    private int front;
    private int rear;
    private int capacity;
    private Object[] queue;

    public MyQueue() {
        this.front = 0;
        this.rear = 0;
        this.capacity = 5;
        queue = new Object[this.capacity];
    }

    public void enqueue(Object data) {
        if (rear == capacity) {
            queue = Arrays.copyOf(queue, capacity * 2);
            capacity = capacity * 2;
        }

        queue[rear] = data;
        rear += 1;
    }

    public Object dequeue() {
        if (front == rear)
            throw new NullPointerException("Queue is empty!");

        Object object = queue[0];

        for (int i = 0; i < rear - 1; i++)
            queue[i] = queue[i + 1];

        rear--;
        return object;
    }

    public Object peek() {
        if (front == rear)
            throw new NullPointerException("Queue is empty!");

        return queue[front];
    }
}
