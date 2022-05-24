package leetcode.patterns;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

import java.util.Objects;

public class RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        if (Objects.isNull(head)) {
            return null;
        }
        if (Objects.isNull(head.getNext())) {
            if (head.getValue() == val) {
                return null;
            }
            return head;
        }

        var cur = head;
        var next = head.getNext();
        while (Objects.nonNull(next)) {
            var tmp = next.getNext();
            if (next.getValue() == val) {
                cur.setNext(tmp);
            } else {
                cur = next;
            }
            next = tmp;
        }

        if (head.getValue() == val) {
            return head.getNext();
        }
        return head;
    }

    public static void main(String[] args) {
        var t1 = new ListNode(new ListNode(new ListNode(null, null,1), null, 1), null, 1);
        Utils.print(removeElements(t1, 1));
    }
}
