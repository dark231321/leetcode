package org.example.leetcode.patterns;

import org.example.leetcode.utils.TreeNode;

public class SymmetricTree {


    /**
     *           1
     *      2        2
     *    4   3    3   4
     *   7 6 5 4  4 5 6 7
     * */
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isSymmetricBfs(root.left, root.right);
    }

    public static boolean isSymmetricBfs(TreeNode left, TreeNode right) {
        if (left != null && right != null) {
            boolean a = isSymmetricBfs(left.right, right.left);
            boolean b = isSymmetricBfs(left.left, right.right);
            return left.val == right.val && a && b;
        } else return left == null && right == null;
    }

    public static void main(String[] args) {

    }
}
