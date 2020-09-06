/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName LinkedListCycleII.java
 * @Description https://leetcode-cn.com/problems/linked-list-cycle-ii/
 * @createTime 2020年09月06日 13:24:00
 */
public class LinkedListCycleII {
    /**
     * Floyd 算法
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        // 1. 先判断是否有环
        ListNode node = getNode(head);
        if (node == null) return null;
        // 2. 第二次迭代-
        while (node != head) {
            head = head.next;
            node = node.next;
        }
        return head;
    }

    /**
     * 环形链表
     *
     * @param head
     * @return
     */
    public ListNode getNode(ListNode head) {
        if (head == null || head.next == null) return null;
        // 快慢指针解决环形链表
        ListNode fastNode = head, slowNode = head;
        while (fastNode != null && fastNode.next != null) {
            fastNode = fastNode.next.next;
            slowNode = slowNode.next;
            if (fastNode == slowNode) {
                return fastNode;
            }
        }
        return null;
    }
}
