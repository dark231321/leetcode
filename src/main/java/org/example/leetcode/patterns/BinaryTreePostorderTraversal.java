package org.example.leetcode.patterns;

import org.example.leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderTraversal(root, new ArrayList<>());
    }

    public List<Integer> postorderTraversal(TreeNode root, List<Integer> res) {
        if (Objects.isNull(root)) return res;
        res = postorderTraversal(root.left, res);
        res = postorderTraversal(root.right, res);
        res.add(root.val);
        return res;
    }

    public static void main(String[] args) {

    }
}
