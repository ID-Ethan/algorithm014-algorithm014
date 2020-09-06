/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName SwapNodesInPairs.java
 * @Description https://leetcode-cn.com/problems/swap-nodes-in-pairs/
 * @createTime 2020年09月05日 17:09:00
 */
public class SwapNodesInPairs {
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode firstNode = head;
//        ListNode secondNode = head.next;
//        firstNode.next = swapPairs(secondNode.next);
//        secondNode.next = firstNode;
//        return secondNode;
//    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;
        dummy.next = head;
        while (head != null && head.next != null) {
            ListNode firstNode = head, secondNode = head.next;
            prev.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            prev = firstNode;
            head = firstNode.next;
        }
        return dummy.next;
    }
}
