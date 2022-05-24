package leetcode.patterns;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

import java.util.Objects;

public class RemoveDuplicatesFromSortedList {

    public static ListNode deleteDuplicates(ListNode head) {
        if (Objects.isNull(head)) return null;
        var cur = head;
        var next = head.getNext();
        while (next != null) {
            ListNode tmp = next.getNext();
            if (cur.getValue() == next.getValue()) {
                if (Objects.nonNull(next.getNext())) {
                    cur.setNext(next.getNext());
                } else {
                    cur.setNext(null);
                }
            } else {
                cur = next;
            }
            next = tmp;
        }
        return head;
    }

    public static void main(String[] args) {
        var t1 = new ListNode(new ListNode(new ListNode(null, null,1), null, 1), null, 1);
        Utils.print(deleteDuplicates(t1));
    }
}
