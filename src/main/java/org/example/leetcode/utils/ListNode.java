package org.example.leetcode.utils;

public class ListNode {
    private ListNode next;
    private ListNode previous;
    private int value;

    public ListNode(int value) {
        this.value = value;
    }

    public ListNode(ListNode next, ListNode previous, int value) {
        this.next = next;
        this.previous = previous;
        this.value = value;
    }

    public ListNode getNext() {
        return next;
    }

    public int getValue() {
        return value;
    }

    public ListNode getPrevious() {
        return previous;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    public void setPrevious(ListNode previous) {
        this.previous = previous;
    }

}
