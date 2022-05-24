package leetcode.patterns;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

import java.util.Objects;

public class MiddleOfTheLinkedList {
    public ListNode middleNode(ListNode head) {
        var fast = head.getNext();
        var slow = head;
        var count = 0;
        while (Objects.nonNull(fast) && Objects.nonNull(fast.getNext())) {
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            count += 2;
        }
        if (Objects.nonNull(fast)) {
            return slow.getNext();
        }
        return slow;
    }

    public static void main(String[] args) {
        var i = Utils.randomLinkedListNode(7, 0, 100);
        Utils.print(i);
        var tmp = new MiddleOfTheLinkedList();
        System.out.println(tmp.middleNode(i).getValue());
    }
}
