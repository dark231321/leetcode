package leetcode.patterns;

import leetcode.utils.TreeNode;

import java.util.Objects;

public class InsertIntoABinarySearchTree {
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (Objects.isNull(root)) return new TreeNode(val);
        if (root.val >= val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {

    }
}
