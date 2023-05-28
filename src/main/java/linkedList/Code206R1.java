package linkedList;

import linkedList.ListNode;

/**
 * User: caserwin
 * Date: 2021/11/21 2:32 下午
 * Description:
 */
public class Code206R1 {
    public static void main(String[] args) {

    }

    public static ListNode reverseList(ListNode node) {
        ListNode pre = null;
        ListNode cur = node;

        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return cur;
    }
}