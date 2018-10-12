package LeetCode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum_zj {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        Arrays.sort(nums);
        int len = nums.length;
        if (nums[0] * 4 > target || nums[len - 1] * 4 < target) {
            return result;
        }

        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                //去重
                continue;
            }
            if (nums[i] << 2 > target) {
                //太大，不用继续
                break;
            }
            if (nums[i] + nums[len - 1] * 3 < target) {
                //太小，直接进入下一个循环
                continue;
            }
            int newTarget = target - nums[i];

            //开始找三个数和为newTarget的过程
            for (int j = i + 1; j < len; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[j] * 3 > newTarget) {
                    break;
                }

                if (nums[j] + (nums[len - 1] << 1) < newTarget) {
                    continue;
                }

                int newNewTarget = newTarget - nums[j];
                //开始搜索两个数的和为newNewTarget

                int lo = j + 1,
                        hi = len - 1;
                while (lo < hi) {
                    while (lo > j + 1 && lo < hi && nums[lo] == nums[lo - 1]) {
                        lo++;
                    }
                    while (hi < len - 1 && lo < hi && nums[hi] == nums[hi + 1]) {
                        hi--;
                    }
                    if (lo >= hi) {
                        break;
                    }
                    int sum = nums[lo] + nums[hi];
                    if (sum < newNewTarget) {
                        lo++;
                    } else if (sum > newNewTarget) {
                        hi--;
                    } else {
                        //得到一个结果
                        ArrayList<Integer> tempRes = new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[lo], nums[hi]));
                        result.add(tempRes);
                        lo++;
                        hi--;
                    }
                }

            }
        }//end of first for
        return result;
    }

    @Test
    public void test4sum() {
        int[] nums = {1, 0, -1, 0, -2, 2};
        int target = 0;
        List<List<Integer>> rest = fourSum(nums, target);
        for (List<Integer> integers : rest) {
            System.out.println(integers);

        }
    }


}
