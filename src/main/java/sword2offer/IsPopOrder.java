package sword2offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * Author:kasumi
 * Date:2018/8/12
 */
public class IsPopOrder {
    public static void main(String... args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        IsPopOrder ipo = new IsPopOrder();
        System.out.println(ipo.IsPopOrder(pushA,popA));
    }
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        if (pushA == null || popA == null || pushA.length != popA.length) {
            return false;
        }
        if (pushA.length == 0) {
            return true;
        }
        if (pushA.length == 1) {
            return popA[0] == pushA[0];
        }


        int len = pushA.length;
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        stack.push(pushA[0]);
        int i = 1;
        while (true) {
            if (!stack.empty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            } else {
                if (i >= len) {
                    break;
                }
                stack.push(pushA[i]);
                i++;
            }

        }
        return j >= len;




    }
}
