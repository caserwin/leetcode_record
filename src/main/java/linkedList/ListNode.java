package linkedList;

/**
 * User: caserwin
 * Date: 2021/10/8 10:27 上午
 * Description:
 */
public class ListNode {
    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
