package org.example.leetcode.other.lists;

import org.example.leetcode.utils.LinkedListNode;
import org.example.leetcode.utils.Utils;

import java.util.Objects;

public class LinkedListKElement {

    private static Integer count = 0;

    public static LinkedListNode recursiveSearch(LinkedListNode node, Integer indexTail) {
        if (Objects.isNull(node)) {
            return null;
        }

        LinkedListNode tmp = recursiveSearch(node.getNext(), indexTail);
        count += 1;
        if (Objects.equals(indexTail, count)) {
            return node;
        }
        return tmp;
    }

    public static LinkedListNode search(LinkedListNode node, int indexTail) {
        LinkedListNode tmp = node;
        node = shiftPointer(node, indexTail - 1);
        if (Objects.isNull(node)) return null;
        while (Objects.nonNull(node.getNext())) {
            node = node.getNext();
            tmp = tmp.getNext();
        }
        return tmp;
    }

    private static LinkedListNode shiftPointer(LinkedListNode node, int size) {
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
