package org.example.leetcode.patterns;

import org.example.leetcode.utils.ListNode;
import org.example.leetcode.utils.Utils;

import java.util.Objects;

public class MergeTwoSortedLists {
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (Objects.isNull(list1) || Objects.isNull(list2)) {
            return Objects.isNull(list1) ? list2 : list1;
        }
        ListNode first;
        if (list1.getValue() < list2.getValue()) {
            first = new ListNode(list1.getValue());
            list1 = list1.getNext();
        } else {
            first = new ListNode(list2.getValue());
            list2 = list2.getNext();
        }

        var tmp = first;
        while (Objects.nonNull(list1) && Objects.nonNull(list2)) {
            ListNode newNode;
            if (list1.getValue() < list2.getValue()) {
                newNode = new ListNode(list1.getValue());
                tmp.setNext(newNode);
                list1 = list1.getNext();
            } else {
                newNode = new ListNode(list2.getValue());
                tmp.setNext(newNode);
                list2 = list2.getNext();
            }
            tmp = newNode;
        }

        tmp.setNext(
                Objects.nonNull(list1) ? list1: list2
        );

        return first;
    }

    public static ListNode mergeTwoListsRecursion(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        if (list1.getValue() < list2.getValue()) {
            list1.setNext(mergeTwoListsRecursion(list1.getNext(), list2));
            return list1;
        } else {
            list2.setNext(mergeTwoListsRecursion(list1, list2.getNext()));
            return list2;
        }
    }

    public static void main(String[] args) {
        var t1 = new ListNode(new ListNode(new ListNode(new ListNode(null, null,4), null,3), null, 2), null, 1);
        var t2 = new ListNode(new ListNode(new ListNode(null, null,3), null, 2), null, 1);
        Utils.print(mergeTwoListsRecursion(t1, t2));
    }
}
