package org.zj.LeetCode.medium;

public class CanIWin {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (maxChoosableInteger >= desiredTotal) {
            return true;
        }
        if ((1 + maxChoosableInteger) * maxChoosableInteger < desiredTotal) {
            return false;
        }



    }
}
