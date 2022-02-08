package org.example.leetcode.utils;

public class LinkedListNode {
    private LinkedListNode next;
    private LinkedListNode previous;
    private int value;

    public LinkedListNode(int value) {
        this.value = value;
    }

    public LinkedListNode(LinkedListNode next, LinkedListNode previous, int value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    public LinkedListNode getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public LinkedListNode getPrevious() {
        return previous;
    }

    public void setNext(LinkedListNode next) {
        this.next = next;
    }

    public void setPrevious(LinkedListNode previous) {
        this.previous = previous;
    }

}
