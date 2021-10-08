package linkedList;

/**
 * User: caserwin
 * Date: 2021/10/8 11:52 上午
 * Description: 反转链表
 */
public class Code206 {
    public static ListNode reverseList(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }

        ListNode cur = node;
        ListNode next = cur.next;
        cur.next = null;

        while (next != null) {
            ListNode tmp = next.next;
            next.next = cur;

            cur = next;
            next = tmp;
        }
        return cur;
    }
}
