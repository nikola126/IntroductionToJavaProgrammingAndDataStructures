package com.programming.java.chapter10;

public class MyQueue {
    private int[] elements;
    private int size;
    private int front;
    public MyQueue() {
        this.size = 8;
        this.front = 0;
        this.elements = new int[8];
    }

    public void enqueue(int element) {
        if (front == size) {
            int[] newElements = new int[size * 2];
            System.arraycopy(elements, 0, newElements, 0, size - 1);
            elements = newElements;
            size = size * 2;
        }
        elements[front] = element;
        front += 1;
    }

    public int dequeue() {
        front -= 1;
        return elements[front + 1];
    }

    public boolean isEmpty() {
        return (front == 0);
    }

    public int getSize() {
        return size;
    }
}
