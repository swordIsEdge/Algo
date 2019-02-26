package org.zj.LeetCode;

import org.zj.dataStructure.TreeNode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-26 15:57
 **/

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBST(nums, 0, nums.length-1);
    }

    private TreeNode getBST(int nums[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);
        root.left = getBST(nums, start, mid - 1);
        root.right = getBST(nums, mid + 1, end);
        return root;
    }
    public static void main(String... args){
        ConvertSortedArrayToBinarySearchTree test = new ConvertSortedArrayToBinarySearchTree();
        TreeNode root = test.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
