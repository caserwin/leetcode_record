package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * User: caserwin
 * Date: 2021/10/2 11:09 上午
 * Description:
 */
public class Code160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}
