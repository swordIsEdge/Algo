package sword2offer;

import dataStructure.TreeNode;

/**
 * Author:kasumi
 * Date:2018/8/6
 */
public class ReConstructBinaryTree {
    int[] pre,in;
    public TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if (pre == null || in == null || pre.length != in.length) {
            return null;
        }
        this.pre = pre;
        this.in = in;
        return reBuild(0, pre.length - 1, 0, in.length - 1);
    }

    private TreeNode reBuild(int pre_start, int pre_end, int in_start, int in_end) {
        if (pre_start == pre_end) {
            return new TreeNode(pre[pre_start]);
        } else if (pre_end < pre_start) {
            return null;
        } else {
            TreeNode root = new TreeNode(pre[pre_start]);
            int i;
            for ( i = in_start; i <= in_end; i++) {
                if (in[i] == pre[pre_start]) {
                    break;
                }
            }
            int leftLenth = i - in_start;
            root.left = reBuild(pre_start + 1, pre_start + leftLenth, in_start, i - 1);
            root.right = reBuild(pre_start + 1 + leftLenth, pre_end, i + 1, in_end);
            return root;

        }

    }
}
