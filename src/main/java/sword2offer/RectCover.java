package sword2offer;

/**
 * Author:kasumi
 * Date:2018/8/7
 */
public class RectCover {
    public int RectCover(int target) {
//        f(n) = f(n-1) + f(n-2)
//        f(0) = 0
//        f(1) = 1
//        f(2) = 2
        if (target <= 0) {
            return 0;
        }
        if (target == 1) {
            return 1;

        }
        if (target == 2) {
            return 2;
        } else {
            int a = 1, b = 2, temp;
            for (int i = 0; i < target - 2; i++) {
                temp = a + b;
                a = b;
                b = temp;
            }
            return b;
        }

    }

}
