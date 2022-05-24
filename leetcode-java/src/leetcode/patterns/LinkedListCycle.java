package leetcode.patterns;

import leetcode.utils.ListNode;

import java.util.IdentityHashMap;
import java.util.Objects;

public class LinkedListCycle {

    /**
     *
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * There is a cycle in a linked list if there is some node in the list that can be
     * reached again by continuously following the next pointer. Internally, pos is used
     * to denote the index of the node that tail's next pointer is connected to.
     * Note that pos is not passed as a parameter.
     *
     * Return true if there is a cycle in the linked list. Otherwise, return false.
     *
     * 3 -> 2 -> 0 -> -4 -> 2
     *
     * 3  2
     * 2 -4
     * 0  0
     *
     *
     * 3 -> 2 ->                      2
     *           0 -> -4 -> 1 -> 3 ->
     *
     *  3  2
     *  2  4
     *  0  3
     * -4  0
     *  1  1
     * */
    public static boolean hasCycle(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.getNext())) return false;

        var slow = head;
        var fast = head.getNext();
        while (Objects.nonNull(fast.getNext()) &&
                Objects.nonNull(fast.getNext().getNext())) {
            if (slow.getValue() == fast.getValue()) {
                return true;
            }
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }

        return false;
    }

    public static boolean hasCycle1(ListNode head) {
        if (Objects.isNull(head)) return false;
        var map = new IdentityHashMap<ListNode, Object>();
        while (Objects.nonNull(head)) {
            if (map.containsKey(head)) {
                return true;
            }
            map.put(head, null);
            head = head.getNext();
        }

        return false;
    }

    public static void main(String[] args) {

    }
}
