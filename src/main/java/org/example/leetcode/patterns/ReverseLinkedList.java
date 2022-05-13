package org.example.leetcode.patterns;

import org.example.leetcode.utils.ListNode;
import org.example.leetcode.utils.Utils;

import java.util.Objects;

public class ReverseLinkedList {

    /**
     *   1 -> 2 -> 3 -> 4
     *   3  ->  4
     *   |      |
     *  prev   cur
     *
     *
     * Given the head of a singly linked list, reverse the list, and return the reversed list
     *
     * Input: head = [1,2,3,4,5]
     * Output: [5,4,3,2,1]
     *
     * Input: head = [1,2]
     * Output: [2,1]
     * */
    private static ListNode reverseList(ListNode cur, ListNode prev) {
        if (Objects.isNull(cur)) {
            return null;
        }
        if (Objects.isNull(cur.getNext())) {
            cur.setNext(prev);
            return cur;
        }
        var reverse = reverseList(cur.getNext(), cur);
        cur.setNext(prev);
        return reverse;
    }

    public static ListNode reverseList(ListNode head) {
        return reverseList(head, null);
    }

    /**
     *
     * 1 -> 2 -> 3 -> 4
     *      |    |
     *     cur  next
     * */
    public static ListNode reverseListIter(ListNode head) {
        if (Objects.isNull(head)) return null;
        var cur = head;
        var next = head.getNext();
        cur.setNext(null);
        while (next != null) {
            ListNode tmp = next.getNext();
            next.setNext(cur);
            cur = next;
            next = tmp;
        }
        return cur;
    }

    public static ListNode reverseListIter1(ListNode head) {
        if (Objects.isNull(head)) {
            return null;
        }
        var cur = head;
        var next = cur.getNext();
        while (next != null) {
            ListNode tmp = next.getNext();
            cur.setNext(next);
            cur = next;
            next = tmp;
        }
        return cur;
    }


    public static void main(String[] args) {
        var t1 = new ListNode(new ListNode(new ListNode(new ListNode(null, null,4), null,3), null, 2), null, 1);
        var t2 = reverseListIter(t1);
        Utils.print(t2);
    }
}
