/**
 * @author ID-Ethan
 * @version 1.0.0
 * @ClassName MergeTwoSortedLists.java
 * @Description 21 https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @createTime 2020年09月06日 18:20:00
 */
public class MergeTwoSortedLists {
//    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
//        if (l1 == null) return l2;
//        if (l2 == null) return l1;
//        if (l1.val >= l2.val) {
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        } else {
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        }
//    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        ListNode pHead = new ListNode(-1);
        // 如果有两个指针 prev 和 pHead 相等(就是指针重合),如果使用 prev.next = cur 改变了 prev.next 的值,那么同时也改变 pHead.next 的值.
        ListNode prev = pHead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return pHead.next;
    }
}
