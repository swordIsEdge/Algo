package org.zj.sword2offer;

/**
 * Author:kasumi
 * Date:2018/8/6
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;
        }
        if (target == 2) {
            return 2;
        }
        int a = 1;
        int b = 2;
        int tmp;
        for (int i = 0; i < target-2; i++) {
            tmp = a + b;
            a = b;
            b = tmp;
        }
        return b;




    }
}
