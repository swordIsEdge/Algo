package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.util.Objects;

/**
 * 学习了答案中一个非常精妙的写法
 **/

public class LowestCommonAncestorOfABinaryTree {
    TreeNode ans;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        core(root, p, q);
        return ans;

    }

    private boolean core(TreeNode cur, TreeNode p, TreeNode q) {
        if (Objects.nonNull(ans)) {
            return false;
        }
        if (cur == null) {
            return false;
        }
        int left = core(cur.left, p, q) ? 1 : 0;
        int right = core(cur.right, p, q) ? 1 : 0;
        int tmp = (cur == p || cur == q) ? 1 : 0;
        if (left + right + tmp >= 2) {
            ans = cur;
        }
        return (left + right + tmp) > 0;
    }
}
