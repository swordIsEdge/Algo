package sword2offer;

import dataStructure.TreeNode;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class TreeMirror {
    public void Mirror(TreeNode root) {
        mirrorNode(root);
    }

    private TreeNode mirrorNode(TreeNode root) {
        if (root == null) return root;
        TreeNode tmp = root.left;
        root.left = mirrorNode(root.right);
        root.right = mirrorNode(tmp);
        return root;
    }
}
