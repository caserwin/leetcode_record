package linkedList;

/**
 * @author yidxue
 * 反转链表
 */
public class Code206R2 {

    public static ListNode reverseList(ListNode node) {
        if (node == null){
            return node;
        }

        ListNode pre = null;
        ListNode cur = node;

        while (cur!=null){
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }
}
