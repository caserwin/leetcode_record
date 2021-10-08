package linkedList;

/**
 * User: caserwin
 * Date: 2021/10/8 1:39 下午
 * Description: 反转链表
 */
public class Code92 {

//    public ListNode reverseBetween(ListNode head, int left, int right) {
//        if (head == null) {
//            return head;
//        }
//
//        int index = 1;
//        ListNode currNode = head;
//        ListNode nextNode = head.next;
//
//        while (nextNode != null) {
//            if (index < left || index > right) {
//                currNode = nextNode;
//                nextNode = nextNode.next;
//                index++;
//                continue;
//            }
//
//            ListNode tmpHead = currNode;
//            currNode.next = null;
//            while (index <= right && index >= left) {
//                // 开始翻转
//                ListNode tmpNode = nextNode.next;
//                nextNode.next = currNode;
//
//                currNode = nextNode;
//                nextNode = tmpNode;
//                index ++;
//            }
//
//            tmpHead.next = currNode;
//
//        }
//
//        return head
//    }
//
//
//
//    private ListNode
//

}
