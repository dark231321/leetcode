package org.example.leetcode.other.lists;

import org.example.leetcode.utils.ListNode;
import org.example.leetcode.utils.Utils;

import java.util.Objects;

public class LinkedListKElement {

    private static Integer count = 0;

    public static ListNode recursiveSearch(ListNode node, Integer indexTail) {
        if (Objects.isNull(node)) {
            return null;
        }

        ListNode tmp = recursiveSearch(node.getNext(), indexTail);
        count += 1;
        if (Objects.equals(indexTail, count)) {
            return node;
        }
        return tmp;
    }

    public static ListNode search(ListNode node, int indexTail) {
        ListNode tmp = node;
        node = shiftPointer(node, indexTail - 1);
        if (Objects.isNull(node)) return null;
        while (Objects.nonNull(node.getNext())) {
            node = node.getNext();
            tmp = tmp.getNext();
        }
        return tmp;
    }

    private static ListNode shiftPointer(ListNode node, int size) {
        while (Objects.nonNull(node) && size > 0) {
            node = node.getNext();
            size --;
        }
        return node;
    }

    public static void main(String[] args) {
        var i = Utils.randomLinkedListNode(3, 0, 5);
        Utils.print(i);
        System.out.println(search(i, 3).getValue());
    }
}
