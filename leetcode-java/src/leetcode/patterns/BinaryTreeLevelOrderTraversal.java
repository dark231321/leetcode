package leetcode.patterns;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BinaryTreeLevelOrderTraversal {
    /**
     * [1,2,3,4,null,null,5]
     *                1             -  1
     *          2           3       -  2
     *       4    null null    5    -  3
     */
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (Objects.isNull(root)) return Collections.emptyList();
        List<List<Integer>> res = new ArrayList<>();
        return levelOrderBfs(root, res, 0);
    }

    public static List<List<Integer>> levelOrderBfs(TreeNode treeNode, List<List<Integer>> res, int depth) {
        if (Objects.isNull(treeNode)) return res;
        if (depth == res.size()) {
            List<Integer> tmp = new ArrayList<>();
            tmp.add(treeNode.val);
            res.add(tmp);
        } else {
            res.get(depth).add(treeNode.val);
        }
        res = levelOrderBfs(treeNode.left, res, depth + 1);
        res = levelOrderBfs(treeNode.right, res, depth + 1);
        return res;
    }

    public static void main(String[] args) {

    }
}
