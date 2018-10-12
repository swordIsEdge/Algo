package dataStructure;

/**
 * Author:kasumi
 * Date:2018/9/25
 */
public class ConstructListNode {
    public static ListNode constructListNode(int[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        ListNode head = new ListNode(lists[0]);
        ListNode d = head;
        for (int i = 1; i < lists.length; i++) {
            d.next = new ListNode(lists[i]);
            d = d.next;

        }
        return head;
    }
    public static void main(String... args){
        ListNode root = constructListNode(new int[]{1, 2, 3});
        System.out.println(root);
    }
}
