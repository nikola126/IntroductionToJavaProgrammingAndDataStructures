package com.programming.java.IntroductionToJavaNakov.ch16_LinearDataStructures;

public class DoublyLinkedList {
    private class Node {
        Object data;
        Node prev;
        Node next;

        public Node(Object data) {
            this.data = data;
            prev = null;
            next = null;
        }
    }

    private Node head;

    private Node tail;
    private int size;

    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(Object data) {
        Node newNode = new Node(data);
        newNode.prev = null;
        newNode.next = head;

        if (head != null)
            head.prev = newNode;

        head = newNode;
        size += 1;
    }

    public void deleteAtIndex(int index) {
        if (head == null || index < 0)
            throw new ArrayIndexOutOfBoundsException("Index out of bounds: " + index);

        Node current = head;
        for (int i = 0; current != null && i < index; i++)
            current = current.next;

        if (current == null)
            return;

        size -= 1;
        deleteNode(current);
    }

    public void insertAtIndex(Object data, int index) {
        Node newNode = new Node(data);

        if (index < 0)
            throw new IllegalArgumentException("Cannot be inserted at index " + index);
        else if (index == 0) {
            // make new node as head
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
            size += 1;
        } else {
            // reach insertion point
            Node temp = head;
            for (int i = 0; i < index - 1; i++)
                if (temp != null)
                    temp = temp.next;

            if (temp != null) {
                newNode.next = temp.next;
                newNode.prev = temp;
                temp.next = newNode;

                size += 1;

                if (newNode.next != null)
                    newNode.next.prev = newNode;
            }
        }

    }

    public Object[] toArray() {
        Object[] asArray = new Object[size];

        Node temp = head;
        if (temp == null)
            return asArray;

        int index = 0;
        while (temp != null) {
            asArray[index] = temp.data;
            temp = temp.next;
            index += 1;
        }

        return asArray;
    }

    public int indexOf(Object item) {
        int index = 0;
        Node current = head;

        while (current != null) {
            if ((current.data != null && current.data.equals(item)) ||
            (current.data == null) && (item == null))
                return index;

            current = current.next;
            index++;
        }

        return -1;
    }

    private Node deleteNode(Node toDelete) {
        if (head == null || toDelete == null)
            return null;

        if (head == toDelete)
            head = toDelete.next;

        if (toDelete.next != null) {
            toDelete.next.prev = toDelete.prev;
        }

        if (toDelete.prev != null) {
            toDelete.prev.next = toDelete.next;
        }

        toDelete = null;
        return head;
    }
}
