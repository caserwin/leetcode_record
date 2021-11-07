package linkedList;

/**
 * @author yidxue
 * 反转链表
 */
public class Code206 {

    public static ListNode reverseList(ListNode node) {
        ListNode pre = null, cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public ListNode reverseList1(ListNode node) {
        if (node == null) {
            return node;
        }

        // head 指向 node第一个节点
        ListNode pre = null, cur = node;
        while (cur.next != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        cur.next = pre;
        return cur;
    }
}
