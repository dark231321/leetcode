package org.example.leetcode.patterns;

import org.example.leetcode.utils.TreeNode;

public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        int expect = targetSum - root.val;
        if (expect == 0 && root.left==null && root.right==null) return true;
        return hasPathSum(root.right, targetSum) || hasPathSum(root.left, targetSum);
    }
}
