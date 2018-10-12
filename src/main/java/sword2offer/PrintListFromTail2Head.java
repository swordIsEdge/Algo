package sword2offer;

import dataStructure.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Author:kasumi
 * Date:2018/8/6
 */
public class PrintListFromTail2Head {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> result = new ArrayList<>();
        if (listNode == null) {
            return result;
        }
        Stack<Integer> s = new Stack<>();
        ListNode temp = listNode;
        while (temp != null) {
            s.push(temp.val);
            temp = temp.next;
        }
        while (!s.empty()) {
            result.add(s.pop());
        }
        return result;


    }
}
