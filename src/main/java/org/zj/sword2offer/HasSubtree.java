package org.zj.sword2offer;

import org.zj.dataStructure.TreeNode;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class HasSubtree {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }
        if (isSame(root1, root2)) {
            return true;
        }
        return HasSubtree(root1.left, root2) || HasSubtree(root1.right, root2);

    }

    private boolean isSame(TreeNode root1, TreeNode root2) {
//        if (root1 == null && root2 == null) {
//            return true;
//        }
//        if (root1 == null || root2 == null) {
//            return false;
//        }
        if (root2 == null) {
            return true;
        }
        if (root1 == null) {
            return false;
        }
        if (root1.val == root2.val) {
            return isSame(root1.left, root2.left) && isSame(root1.right, root2.right);
        }
        return false;
    }
}
