package linkedList;

/**
 * @author yidxue
 * 1. 核心是先找到倒数第 n+1 个节点
 * 2. 怎么找？一个先走k步、另一个再开始走。
 */
public class Code19 {
    public static void main(String[] args) {

    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 涉及到删除操作，必须有个虚拟变量
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode x = findFromEnd(dummy, n + 1);
        // 删掉倒数第 n 个节点
        x.next = x.next.next;
        return dummy.next;
    }

    /**
     * 返回链表的倒数第 k 个节点
     */
    ListNode findFromEnd(ListNode head, int k) {
        ListNode p1 = head;
        // p1 先走 k 步
        for (int i = 0; i < k; i++) {
            p1 = p1.next;
        }
        ListNode p2 = head;
        // p1 和 p2 同时走 n - k 步
        while (p1 != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        // p2 现在是第 n-k-1 个节点, 指向第 n-k 个节点
        return p2;
    }
}
