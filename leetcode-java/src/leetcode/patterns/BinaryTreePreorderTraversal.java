package leetcode.patterns;

import leetcode.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class BinaryTreePreorderTraversal {
    /**
     *                    1
     *                 2     3
     *              2    3 7   8
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        return dfs(root, new ArrayList<>());
    }

    private List<Integer> dfs(TreeNode root, List<Integer> res) {
        if (Objects.isNull(root)) return res;
        res.add(root.val);
        res = dfs(root.left, res);
        return dfs(root.right, res);
    }


}
