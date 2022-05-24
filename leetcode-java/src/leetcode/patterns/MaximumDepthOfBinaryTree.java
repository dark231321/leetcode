package leetcode.patterns;

import leetcode.utils.TreeNode;

import java.util.Objects;

public class MaximumDepthOfBinaryTree {

    public static int maxDepth(TreeNode root) {
        return depthBfs(root, 0);
    }

    public static int depthBfs(TreeNode root, int depth) {
        if (Objects.isNull(root)) return depth;
        depth++;
        var tmp = Math.max(depth, depthBfs(root.left, depth));
        return Math.max(tmp, depthBfs(root.right, depth));
    }

    public static void main(String[] args) {

    }
}
