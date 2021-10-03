package array;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * User: caserwin
 * Date: 2021/10/2 2:37 下午
 * Description:
 */
public class Code215 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 5, 6, 4};
        int k = 2;
        System.out.println(new Code215().findKthLargest(nums, k));
    }

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int num : nums) {
            queue.add(num);
        }

        int res = -1;
        while (k > 0) {
            res = queue.poll();
            k--;
        }
        return res;
    }
}
