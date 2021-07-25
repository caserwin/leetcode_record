/**
 * User: caserwin
 * Date: 2021/7/25 10:23 下午
 * Description:
 */
public class Code21 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode resNode = new ListNode(0);
        // TODO 记住这里是：ListNode curNode = resNode ，而非 ListNode curNode = resNode.next
        ListNode curNode = resNode;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                if (l1.val <= l2.val) {
                    curNode.next = new ListNode(l1.val);
                    l1 = l1.next;
                    curNode = curNode.next;
                    continue;
                } else {
                    curNode.next = new ListNode(l2.val);
                    l2 = l2.next;
                    curNode = curNode.next;
                    continue;
                }
            }

            if (l1 != null) {
                curNode.next = new ListNode(l1.val);
                l1 = l1.next;
                curNode = curNode.next;
                continue;
            }

            if (l2 != null) {
                curNode.next = new ListNode(l2.val);
                l2 = l2.next;
                curNode = curNode.next;
            }
        }
        return resNode.next;
    }
}
