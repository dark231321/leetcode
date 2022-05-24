package leetcode.patterns;

import leetcode.utils.Node;

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

    }
}
