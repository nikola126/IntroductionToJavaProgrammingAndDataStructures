package com.programming.java.IntroductionToJavaNakov.ch16_LinearDataStructures;

import java.io.File;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Stack;

public class ChapterSixteen {
    public static void taskOne() {
        DoublyLinkedList list = new DoublyLinkedList();
        System.out.println("Size: " + list.size());

        list.push(10);
        list.push(20);
        list.push(30);
        System.out.println("Size: " + list.size());
        System.out.println(Arrays.toString(list.toArray()));

        list.deleteAtIndex(1);
        System.out.println("Size: " + list.size());
        System.out.println(Arrays.toString(list.toArray()));

        System.out.println("Index of 30: " + list.indexOf(30));
        System.out.println("Index of 20: " + list.indexOf(20));

        list.insertAtIndex(45, 1);
        System.out.println("Size: " + list.size());
        System.out.println(Arrays.toString(list.toArray()));
    }

    public static void taskTwo() {
        DynamicStack stack = new DynamicStack();
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println(stack.peek());

        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
    }

    public static void taskThree() {
        MyDeque deque = new MyDeque();
        deque.addFirst(30);
        deque.addFirst(40);
        deque.addLast(20);
        deque.addLast(10);

        while (!deque.isEmpty())
            System.out.println(deque.deleteFirst());
    }

    public static void taskFour() {
        MyQueue queue = new MyQueue();
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        System.out.println(queue.peek());

        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
        System.out.println(queue.dequeue());
    }

    public static void taskFive() {
        DynamicList dynamicList = new DynamicList();
        dynamicList.add(4);
        dynamicList.add(42);
        dynamicList.add(15);
        dynamicList.add(23);
        dynamicList.add(8);
        dynamicList.add(16);

        System.out.println("Before sort: ");
        for (int i = 0; i < dynamicList.getLength(); i++) {
            System.out.print(dynamicList.elementAt(i) + " ");
        }
        System.out.println();

        dynamicList.sort();

        System.out.println("Sorted: ");
        for (int i = 0; i < dynamicList.getLength(); i++) {
            System.out.print(dynamicList.elementAt(i) + " ");
        }
        System.out.println();
    }

    public static void taskSix() {
        String HOME = "./src/";

        Queue<String> directories = new ArrayDeque<>();

        directories.offer(HOME);

        System.out.println("Directories BFS");
        while (!directories.isEmpty()) {
            String currentDirectory = directories.poll();
            System.out.println(currentDirectory);

            File dir = new File(currentDirectory);
            for (File file : dir.listFiles()) {
                if (file.isDirectory())
                    directories.offer(file.getAbsolutePath());
            }
        }
    }

    public static void taskSeven() {
        String HOME = "./src/";

        Stack<String> directories = new Stack<>();

        directories.push(HOME);

        System.out.println("Directories DFS");
        while (!directories.isEmpty()) {
            String currentDirectory = directories.pop();
            System.out.println(currentDirectory);

            File dir = new File(currentDirectory);
            for (File file : dir.listFiles()) {
                if (file.isDirectory())
                    directories.push(file.getAbsolutePath());
            }
        }
    }

    public static void main(String[] args) {
        taskOne();
        taskTwo();
        taskThree();
        taskFour();
        taskFive();
        taskSix();
        taskSeven();
    }
}
