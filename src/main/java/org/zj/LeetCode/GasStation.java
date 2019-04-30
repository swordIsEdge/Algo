package org.zj.LeetCode;


/**
 * @program: Algo
 * @description:
 * @author: kasumi
 * @create: 2019-02-28 10:20
 **/

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        if (n == 0) {
            return -1;
        }
        if (n == 1) {
            return gas[0] >= cost[0] ? 0 : -1;
        }

        int[] diff = new int[n], nextIndex = new int[n];
        long sum = 0;

        for (int i = 0; i < n; i++) {
            diff[i] = gas[i] - cost[i];
            sum += diff[i];
            nextIndex[i] = -1;
        }

        if (sum < 0) {
            return -1;
        }

        int tmp = 0, lastStart = -1;
        for (int i = 0; i < n; i++) {
            if (diff[i] < 0) {
                continue;
            } else {
                lastStart = i;
                int j;
                for (j = i; j < n; j++) {
                    if (tmp + diff[j] < 0) {
                        break;
                    }
                    tmp += diff[j];
                }
                diff[i] = tmp;
                tmp = 0;
                nextIndex[i] = j;

                if (j == n) {
                    break;
                }
                i = j - 1;
            }
        }
        if (lastStart == 0) {
            return 0;
        }

        tmp = diff[lastStart];
        for (int i = 0; i < lastStart; ) {
            tmp += diff[i];
            if (tmp < 0) {
                return -1;
            }
            i = Math.max(i + 1, nextIndex[i]);
        }
        return lastStart;
    }

    public static void main(String... args) {
        int[] gas = {4};
        int[] cost = {5};
        int res = new GasStation().canCompleteCircuit(gas, cost);
        System.out.print(res);

    }
}
