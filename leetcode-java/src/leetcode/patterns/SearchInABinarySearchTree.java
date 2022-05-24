package leetcode.patterns;

import leetcode.utils.TreeNode;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class SearchInABinarySearchTree {
    public TreeNode searchBST(TreeNode root, int val) {
        return searchCompare(root, val);
    }

    public TreeNode searchCompare(TreeNode treeNode, int val) {
        if (Objects.isNull(treeNode) || treeNode.val == val) return treeNode;
        if (treeNode.val > val) {
            return searchCompare(treeNode.left, val);
        }
        return searchCompare(treeNode.right, val);
    }

    public TreeNode searchBFS(TreeNode treeNode, int val) {
        Queue<TreeNode> treeNodes = new LinkedList<>();
        treeNodes.add(treeNode);
        while (!treeNodes.isEmpty()) {
            var size = treeNodes.size();
            while (size-- > 0) {
                var tmp = treeNodes.poll();
                if (Objects.isNull(tmp)) continue;
                if (tmp.val == val) return tmp;
                treeNodes.add(tmp.left);
                treeNodes.add(tmp.right);
            }
        }
        return null;
    }

    public TreeNode searchDFS(TreeNode root, int val) {
        if (Objects.isNull(root) || root.val == val) {
            return root;
        }
        var right = searchDFS(root.right, val);
        var left = searchDFS(root.left, val);
        if (Objects.isNull(right) && Objects.isNull(left)) {
            return null;
        }
        return Objects.isNull(right) ? left : right;
    }

    public static void main(String[] args) {

    }
}
