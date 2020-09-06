/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName ReverseLinkedList.java
 * @Description https://leetcode-cn.com/problems/reverse-linked-list/
 * @createTime 2020年09月05日 15:08:00
 */
public class ReverseLinkedList {
//    public ListNode reverseList(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode prev = null;
//        while (head != null) {
//            // head递进，每次保存上一个节点
//            ListNode temp = head.next;
//            head.next = prev;
//            prev = head;
//            head = temp;
//        }
//        return prev;
//    }

    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;

    }
}
