package linkedList;

/**
 * User: caserwin
 * Date: 2021/10/8 10:27 上午
 * Description:
 */
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
