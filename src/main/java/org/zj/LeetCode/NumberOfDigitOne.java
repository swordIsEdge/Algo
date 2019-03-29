
package org.zj.LeetCode;

/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-03-24 11:46
 **/

public class NumberOfDigitOne {
    public static void main(String... args){
        int n = 123;
        NumberOfDigitOne nodo = new NumberOfDigitOne();
        int res = nodo.countDigitOne(n);
        System.out.println(res);
    }
    public int countDigitOne(int n) {

        int pre = n, cur = 0, bit = 1, tail = 0;
        int sum = 0;
        while (pre>0) {
            cur = pre % 10;
            pre = pre / 10;
            switch (cur) {
                case 0:
                    sum += pre * bit;
                    break;
                case 1:
                    sum += pre * bit + tail + 1;
                    break;
                default:
                    sum += pre * bit + bit;
                    break;

            }
            tail = tail + cur * bit;
            bit *= 10;
        }
        return sum;
    }
}
