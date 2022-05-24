package leetcode.patterns;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        return bfs(root, new ArrayList<>());
    }

    // Inorder Left Root Right
    public List<Integer> bfs(TreeNode root, List<Integer> res) {
        if (Objects.isNull(root)) return res;

        res = bfs(root.left, res);
        res.add(root.val);
        return bfs(root.right, res);
    }
}
