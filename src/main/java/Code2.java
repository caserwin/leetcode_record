/**
 * User: caserwin
 * Date: 2021-07-24 22:08
 * Description:
 */
public class Code2 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public static void main(String[] args) {

//        ListNode listNode1 = new ListNode(2);
//        ListNode listNode2 = new ListNode(4);
//        ListNode listNode3 = new ListNode(3);
//        listNode1.next = listNode2;
//        listNode2.next = listNode3;
//
//
//        ListNode listNode4 = new ListNode(5);
//        ListNode listNode5 = new ListNode(6);
//        ListNode listNode6 = new ListNode(4);
//        listNode4.next = listNode5;
//        listNode5.next = listNode6;

        ListNode listNode1 = new ListNode(9);
        ListNode listNode2 = new ListNode(9);
        listNode1.next = listNode2;

        ListNode listNode3 = new ListNode(9);
        ListNode listNode4 = new ListNode(9);
        ListNode listNode5 = new ListNode(9);
        listNode3.next = listNode4;
        listNode4.next = listNode5;


        ListNode resNode = addTwoNumbers(listNode1, listNode3);

        while (resNode != null){
            System.out.println(resNode.val);
            resNode = resNode.next;
        }

    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode resNode = new ListNode(0);
        ListNode curNode = resNode;

        int next = 0;
        int val ;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
                val = l1.val + l2.val + next;
                next = 0;
                if (val >= 10) {
                    val = val - 10;
                    next = 1;
                }

                curNode.next = new ListNode(val);
                l1 = l1.next;
                l2 = l2.next;
                curNode = curNode.next;
                continue;
            }

            if (l1 != null && l2 == null) {
                val = l1.val + next;
                next = 0;
                if (val >= 10) {
                    val = val - 10;
                    next = 1;
                }

                curNode.next = new ListNode(val);
                l1 = l1.next;
                curNode = curNode.next;
                continue;
            }

            if (l1 == null && l2 != null) {
                val = l2.val + next;
                next = 0;
                if (val >= 10) {
                    val = val - 10;
                    next = 1;
                }

                curNode.next = new ListNode(val);
                l2 = l2.next;
                curNode = curNode.next;
                continue;
            }

        }

        if (next == 1){
            curNode.next = new ListNode(1);
        }

        return resNode.next;
    }
}
