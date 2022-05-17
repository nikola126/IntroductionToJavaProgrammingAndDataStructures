package com.programming.java.IntroductionToJavaNakov.ch16_LinearDataStructures;

/**
 * Represents dynamic list implementation
 *
 * @author Tsvyatko Konov
 * @author Svetlin Nakov
 */
public class DynamicList {
    private class Node {
        int element;
        Node next;

        Node(int element, Node prevNode) {
            this.element = element;
            prevNode.next = this;
        }

        Node(int element) {
            this.element = element;
            next = null;
        }
    }

    private Node head;
    private Node tail;
    private int count;

    public DynamicList() {
        this.head = null;
        this.tail = null;
        this.count = 0;
    }

    /**
     * Add element at the end of the list
     *
     * @param item - the element you want to add
     */
    public void add(int item) {
        if (head == null) {
            // We have empty list
            head = new Node(item);
            tail = head;
        } else {
            // We have non-empty list
            Node newNode = new Node(item, tail);
            tail = newNode;
        }
        count++;
    }

    public void sort() {
        Node currentNode = head;
        Node indexNode = null;
        int temp;

        if (head == null)
            return; // nothing to sort

        while (currentNode != null) {
            indexNode = currentNode.next;

            while (indexNode != null) {
                if (currentNode.element > indexNode.element) {
                    // swap
                    temp = currentNode.element;
                    currentNode.element = indexNode.element;
                    indexNode.element = temp;
                }

                indexNode = indexNode.next;
            }

            currentNode = currentNode.next;
        }
    }

    /**
     * Removes the specified item and return its index
     *
     * @param item – the item for removal
     * @return the index of the element or -1 if does not exist
     */
    public int remove(int item) {
// Find the element containing searched item
        int currentIndex = 0;
        Node currentNode = head;
        Node prevNode = null;
        while (currentNode != null) {
            if (currentNode.element == item) {
                break;
            }
            prevNode = currentNode;
            currentNode = currentNode.next;
            currentIndex++;
        }
        if (currentNode != null) {
            // Element is found in the list. Remove it
            count--;
            if (count == 0) {
                head = null;
                tail = null;
            } else if (prevNode == null) {
                head = currentNode.next;
            } else {
                prevNode.next = currentNode.next;
            }
            return currentIndex;
        } else {
            // Element is not found in the list
            return -1;
        }
    }

    /**
     * Searches for given element in the list
     *
     * @param item - the item you are searching for
     * @return the index of the first occurrence of
     * the element in the list or -1 when not found
     */
    public int indexOf(int item) {
        int index = 0;
        Node current = head;
        while (current != null) {
            if (current.element == item) {
                return index;
            }
            current = current.next;
            index++;
        }
        return -1;
    }

    /**
     * Check if the specified element exist in the list
     *
     * @param item - the item you are searching for
     * @return true if the element exist or false otherwise
     */
    public boolean contains(int item) {
        int index = indexOf(item);
        return index != -1;
    }

    /**
     * @param index – the position of the element [0 … count-1]
     * @return the object at the specified index
     * @throws IndexOutOfBoundsException - when index is invalid
     */
    public int elementAt(int index) {
        if (index >= count || index < 0) {
            throw new IndexOutOfBoundsException(
                    "Invalid index: " + index);
        }
        Node currentNode = this.head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode.element;
    }

    /**
     * @return the actual list length
     */
    public int getLength() {
        return count;
    }
}
