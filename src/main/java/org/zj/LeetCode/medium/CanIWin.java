package org.zj.LeetCode.medium;

import org.zj.LeetCode.FactorialTrailingZeroes;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger < desiredTotal) {
            return false;
        }
        return false;


    }
}
