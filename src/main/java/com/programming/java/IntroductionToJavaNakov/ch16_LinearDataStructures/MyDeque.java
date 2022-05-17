package com.programming.java.IntroductionToJavaNakov.ch16_LinearDataStructures;

import java.util.Stack;

public class MyDeque {
    Stack<Object> frontStack;
    Stack<Object> endStack;

    public MyDeque() {
        this.frontStack = new Stack<>();
        this.endStack = new Stack<>();
    }

    public void addFirst(Object object) {
        frontStack.push(object);
    }

    public Object deleteFirst() {
        if (frontStack.isEmpty()) {
            while (!endStack.isEmpty())
                frontStack.push(endStack.pop());
            return frontStack.pop();
        }
        return frontStack.pop();
    }

    public void addLast(Object object) {
        endStack.push(object);
    }

    public Object deleteLast() {
        if (endStack.isEmpty()) {
            while (!frontStack.isEmpty())
                endStack.push(frontStack.pop());
            return endStack.pop();
        }
        return endStack.pop();
    }

    public int size() {
        return frontStack.size() + endStack.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }
}
