package linkedList;

/**
 * 删除排序链表中的重复元素
 */
public class Code83 {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(1);
        ListNode node3 = new ListNode(2);

        node1.next = node2;
        node2.next = node3;

        ListNode resNode = new Code83().deleteDuplicates(node1);
        while (resNode != null) {
            System.out.println(resNode.val);
            resNode = resNode.next;
        }
    }

    /**
     * 链表核心：用一个指针指向链表的某个位置。比如：指向链表头，就写：ListNode curNode = head;
     */
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode curNode = head;
        while (curNode.next != null) {
            // 断开连接
            if (curNode.val == curNode.next.val) {
                curNode.next = curNode.next.next;
            } else {
                curNode = curNode.next;
            }
        }
        return head;
    }
    /*
     * 问：已经回到链表的末尾了，怎么回到链表头部呢？
     * 答：指定 curNode 指针指向链表的头部。整体还是对链表操作，和当前指向的节点无关。
     */
}