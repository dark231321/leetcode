package leetcode.patterns;

import leetcode.utils.TreeNode;

public class InvertBinaryTree {

    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        invertTreeDfs(root);
        return root;
    }

    public void invertTreeDfs(TreeNode root) {
        if (root == null) return;
        var tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.right);
        invertTree(root.left);
    }

    public static void main(String[] args) {

    }
}
