/**
 * User: caserwin
 * Date: 2021/7/26 5:01 下午
 * Description:
 */
public class Code141 {
    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {

    }

    /**
     * 这里判断条件是：while (slow.next != null && fast.next!=null && fast.next.next !=null)
     * 而非：while (slow.next != null && fast.next.next !=null) {
     */
    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (slow.next != null && fast.next!=null && fast.next.next !=null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast){
                return true;
            }
        }
        return false;
    }
}
