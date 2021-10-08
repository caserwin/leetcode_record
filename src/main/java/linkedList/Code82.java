package linkedList;

/**
 * User: caserwin
 * Date: 2021/10/8 10:49 上午
 * Description:
 */
public class Code82 {

    public static void main(String[] args) {
//        ListNode node1 = new ListNode(1);
//        ListNode node2 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node4 = new ListNode(3);
//        ListNode node5 = new ListNode(4);
//        ListNode node6 = new ListNode(4);
//        ListNode node7 = new ListNode(5);
//
//        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;
//        node5.next = node6;
//        node6.next = node7;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
//        ListNode node3 = new ListNode(2);

//        ListNode node3 = new ListNode(1);
//        ListNode node4 = new ListNode(2);
//        ListNode node5 = new ListNode(3);
        node1.next = node2;
//        node2.next = node3;
//        node3.next = node4;
//        node4.next = node5;

        ListNode resNode = new Code82().deleteDuplicates(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode lastNode = new ListNode(Integer.MAX_VALUE);
        lastNode.next = head;
        // head 必须指向链表第一个元素
        head = lastNode;

        // curNode 指向新链表的第二个元素
        ListNode curNode = head.next;
        int curSameNum = Integer.MAX_VALUE;

        while (curNode.next != null) {
            if (curNode.next.val == curNode.val) {
                curNode.next = curNode.next.next;
                curSameNum = curNode.val;
            } else {
                // 如果相同，则删除当前节点
                if (curNode.val == curSameNum) {
                    lastNode.next = curNode.next;
                    curNode = lastNode.next;      // 第一次提交报错，这里少一步
                } else {
                    lastNode = curNode;
                    curNode = curNode.next;
                }
            }
        }

        // 判断当前节点要不要删除
        if (curNode.val == curSameNum){
            lastNode.next = null;
        }

        return head.next;
    }
}
