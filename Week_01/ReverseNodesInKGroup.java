/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName ReverseNodesInKGroup.java
 * @Description https://leetcode-cn.com/problems/reverse-nodes-in-k-group/
 * @createTime 2020年09月06日 13:34:00
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || k == 1) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode cur = dummy, nex = dummy, pre = dummy;
        // 每次翻转k个节点，如果剩下的节点不足k个则不翻转，那么首先就要知道链表的长度
        int count = 0;
        while (cur.next != null) {
            cur = cur.next;
            count++;
        }
        // 判断剩下的节点是否满足k个大小
        while (count >= k) {
            cur = pre.next;
            nex = cur.next;
            for (int i = 1; i < k; i++) {
                cur.next = nex.next;
                nex.next = pre.next;
                pre.next = nex;
                nex = cur.next;
            }
            pre = cur;
            count -= k;
        }
        return dummy.next;

    }
}
