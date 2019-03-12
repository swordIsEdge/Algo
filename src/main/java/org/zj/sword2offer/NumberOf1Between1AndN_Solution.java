package org.zj.sword2offer;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-12 15:07
 **/

public class NumberOf1Between1AndN_Solution {
    public int NumberOf1Between1AndN_Solution(int n) {

        if (n < 1) {
            return 0;
        }
        int left = 1, right = 1, temp = 1;
        int times = 0;
        int product = 1;
        for (int i = 0; left != 0; i++) {
            right = n % product;
            left = n / product / 10;
            temp = n / product % 10;
            int sum = left * product +( temp > 1 ? product : temp*(right+1));
            times += sum;
            product *= 10;

        }
        return times;

    }
    public static void main(String... args){
        new NumberOf1Between1AndN_Solution().NumberOf1Between1AndN_Solution(23457);
    }
}
