package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * @author casyd_xue
 * 环形链表 II：给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 */
public class Code142 {
    public ListNode detectCycle(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
}