package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-28 09:02
 **/

public class PathSumII {
    List<List<Integer>> result;

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        core(root, sum, new ArrayList<>());
        return result;
    }

    private void core(TreeNode root, int target, List<Integer> path) {
        if (root == null) {
            return;
        }
        int val = root.val;
        List<Integer> tmp = new ArrayList<>(path);
        tmp.add(val);
        if (val == target && root.left == null && root.right == null) {
            result.add(tmp);
            return;
        }

        core(root.left, target - val, tmp);
        core(root.right, target - val, tmp);
    }

    public static void main(String... args) {
        TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);
        int sum = -5;
        PathSumII test = new PathSumII();
        test.pathSum(root, sum);
    }
}
