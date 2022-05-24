package leetcode.patterns;

import leetcode.utils.ListNode;
import leetcode.utils.Utils;

import java.util.Objects;

public class RemoveNthNodeFromEndOfList {

    public class Count {
        public Integer count;

        public Count(Integer count) {
            this.count = count;
        }
    }

    /**
     * 1,2,3,4,5 2
     * 1 2 3 5
     * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var size = new Count(0);
        var tmp = head;
        var faster = shift(head, n, size);
        var previous = tmp;
        if (n == size.count && Objects.isNull(faster)) {
            return head.getNext();
        }

        while (Objects.nonNull(faster)) {
            faster = faster.getNext();
            previous = tmp;
            tmp = tmp.getNext();
        }
        previous.setNext(tmp.getNext());
        return head;
    }

    public ListNode shift(ListNode head, int n, Count size) {
        var tmp = head;
        while (Objects.nonNull(tmp) && n > 0) {
            tmp = tmp.getNext();
            n--;
            size.count++;
        }
        return tmp;
    }

    public static void main(String[] args) {
        var tmp = Utils.randomLinkedListNode(5, 0, 10);
        Utils.print(tmp);
        var cl = new RemoveNthNodeFromEndOfList();
        Utils.print(cl.removeNthFromEnd(tmp, 2));
    }
}
