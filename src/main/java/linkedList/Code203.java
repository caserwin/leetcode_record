package linkedList;

/**
 * User: caserwin
 * Date: 2021/10/8 11:52 上午
 * Description:
 */
public class Code203 {
    /**
     * 因为会删除当前节点，所以需要另一个 pre 节点辅助记录
     */

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = pre.next;

        while (cur != null) {
            if (cur.val == val) {
                pre.next = cur.next;
                cur = cur.next;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        if (head.val == val) {
            return head.next;
        } else {
            return head;
        }
    }
}
