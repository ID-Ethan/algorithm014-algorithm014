/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName LinkedListCycle.java
 * @Description https://leetcode-cn.com/problems/linked-list-cycle
 * @createTime 2020年09月06日 13:04:00
 */
public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        // 快慢指针解决环形链表
        ListNode fastNode = head, slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return true;
            }
        }
        return false;
    }
}
