package leetcode.patterns;

import leetcode.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Objects;

public class MergeTwoBinaryTrees {

    /**
     *          1             2            3
     *       2    3        1     3      3    6
     *     1            1    1       1    1
     *
     * */
    public static TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (Objects.isNull(root1) || Objects.isNull(root2)) {
            return Objects.isNull(root1) ? root2 : root1;
        }

        return fillTrees(root1, root2);
    }

    public static TreeNode fillTrees(TreeNode first, TreeNode second) {
        if (Objects.isNull(first) || Objects.isNull(second)) {
            return Objects.nonNull(first) ? first : second;
        }

        first.val += second.val;
        first.left = fillTrees(first.left, second.left);
        first.right = fillTrees(first.right, second.right);
        return first;
    }

    public static TreeNode mergeTrees1(TreeNode first, TreeNode second) {
        if (Objects.isNull(first) || Objects.isNull(second)) {
            return Objects.nonNull(first) ? first : second;
        }
        return new TreeNode(
                first.val + second.val,
                mergeTrees1(first.left, second.left),
                mergeTrees1(first.right, second.right)
        );
    }

    public static TreeNode stackMergeTrees(TreeNode first, TreeNode second) {
        if (first == null) {
            return second;
        }
        Deque<TreeNode[]> deque = new ArrayDeque<>();
        deque.add(new TreeNode[]{first, second});
        
        while (!deque.isEmpty()) {
            var tmp = deque.pop();
            if (tmp[0] == null || tmp[1] == null) {
                continue;
            }
            tmp[0].val += tmp[1].val;
            if (tmp[0].left == null) {
                tmp[0].left = tmp[1].left;
            } else {
                deque.add(new TreeNode[]{tmp[0].left, tmp[1].left});
            }
            if (tmp[0].right == null) {
                tmp[0].right = tmp[1].right;
            } else {
                deque.add(new TreeNode[]{tmp[0].right, tmp[1].right});
            }
        }
        return first;
    }

    public static void main(String[] args) {
        var tmp = new TreeNode(1, new TreeNode(2, new TreeNode(3), null), new TreeNode(3, null, null));
        var tmp1 = new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, new TreeNode(3), null));
        var t = stackMergeTrees(tmp, tmp1);
        System.out.println();
    }
}
