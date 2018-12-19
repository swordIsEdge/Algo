package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2018-12-18 15:54
 **/

public class SortColors {
    public void sortColors(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            while (j < nums.length && nums[j] == 1) {
                j++;
            }
//            printArray(nums,i,j,k);
            while (k >= 0 && nums[k] == 2) {
                k--;
            }
//            printArray(nums,i,j,k);

            if (j > k) {
                break;
            }
            if (nums[j] == 0) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++;
                j++;
            }
//            printArray(nums,i,j,k);

            if (j >= nums.length||j>k) {
                break;
            }
            if (nums[j] == 2) {
                int temp = nums[j];
                nums[j] = nums[k];
                nums[k] = temp;
                k--;

            }
//            printArray(nums,i,j,k);
        }
    }
    public static void main(String... args){
        int[] nums = {0, 1, 0, 2, 0, 0, 1, 2, 2, 0, 1, 0, 2, 2, 1};

        new SortColors().sortColors(nums);
        for (int num : nums) {
            System.out.print(num);
            System.out.print(", ");
        }
        System.out.println();
    }

    private void printArray(int[] nums, int i,int j, int k) {
        for (int num : nums) {
            System.out.print(String.format("%4d",num));
            System.out.print(", ");
        }
        System.out.println();
        for (int l = 0; l < i; l++) {
            System.out.print("      ");

        }
        System.out.println("   i");
        for (int l = 0; l < j; l++) {
            System.out.print("      ");

        }
        System.out.println("   j");
        for (int l = 0; l < k; l++) {
            System.out.print("      ");

        }
        System.out.println("   k");
        System.out.println();
    }
}
