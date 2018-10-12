package sword2offer;

/**
 * Author:kasumi
 * Date:2018/8/6
 */
public class JumpFloorII {
    public int JumpFloorII(int target) {
        if (target <= 0) {
            return 0;
        }
        int n = target - 1;
        return (int)(Math.pow(2, n)+0.5);
    }

}
