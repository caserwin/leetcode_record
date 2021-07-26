import java.util.Stack;

/**
 * User: caserwin
 * Date: 2021/7/26 5:45 下午
 * Description:
 */
public class OfferCode24 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);

        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;

        ListNode reList = reverseListNode(listNode1);
        while (reList != null) {
            System.out.println(reList.val);
            reList = reList.next;
        }
    }

    /**
     * 迭代法
     * TODO 注意点：这里最后是 return lastNode; 而不是 curNode
     */
    public static ListNode reverseListNode(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        // 上一个节点
        ListNode lastNode = head;
        ListNode curNode = head.next;
        lastNode.next = null;

        while (curNode != null) {
            ListNode nextNode = curNode.next;
            curNode.next = lastNode;

            // 更新节点
            lastNode = curNode;
            curNode = nextNode;
        }
        return lastNode;
    }
}
