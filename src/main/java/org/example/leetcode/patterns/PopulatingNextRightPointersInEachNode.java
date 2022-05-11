package org.example.leetcode.patterns;

import org.example.leetcode.utils.Node;

import java.util.Objects;

/**
 *       1 -> null
 *    2 -> 3 -> null
 *  4 ->5 6-> 7-> null
 *
 *
 * */
public class PopulatingNextRightPointersInEachNode {
    public static Node connect(Node root) {
        if (root == null) {
            return null;
        }
        connectRecursive(root, root.left, false);
        connectRecursive(root, root.right, true);
        return root;
    }

    public static Node connectRecursive(Node parent, Node tmp, Boolean isRight) {
        if (tmp == null) {
            return null;
        }

        if (isRight) {
            if (parent.next == null || parent.next.right == null) {
                tmp.next = null;
            } else {
                tmp.next = parent.next.left;
            }
            parent.left.next = tmp;
        } else {
            tmp.next = parent.right;
        }
        connectRecursive(tmp, tmp.left, false);
        connectRecursive(tmp, tmp.right, true);
        return tmp;
    }

    public static void main(String[] args) {
        var i = connect(new Node(1,
                new Node(2,
                        new Node(4,
                                new Node(8, null, null, null),
                                new Node(9, null, null, null),
                                null),
                        new Node(5,
                                new Node(10, null, null, null),
                                new Node(11, null, null, null),
                                null),
                        null),
                new Node(3,
                        new Node(6,
                                new Node(12, null, null, null),
                                new Node(13, null, null, null),
                                null),
                        new Node(7,
                                new Node(14, null, null, null),
                                new Node(15, null, null, null),
                                null),
                        null),
                null));

        System.out.println();
    }
}
