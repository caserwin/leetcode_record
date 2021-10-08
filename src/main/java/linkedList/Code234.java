package linkedList;

import java.util.ArrayList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/10/2 11:21 上午
 * Description: 回文链表
 */
public class Code234 {

    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }

        int left = 0;
        int right = list.size() - 1;

        while (left < right) {
            if (list.get(left).intValue() != list.get(right).intValue()) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
