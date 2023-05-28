package tp;

import java.util.LinkedList;

/**
 * @author casyd_xue
 */
public class Code209R1 {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     * 示例: 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     * <p>
     * 首先我们移动R，使得滑动窗口的区间满足给定的条件，然后我们再移动L，直到滑动区间不再满足给定的条件，如此循环往复，并在其过程中记录最优值。
     */
    public static void main(String[] args) {
        int[] array = {2,16,14,15};
        System.out.println(new Code209R1().minSubArrayLen(20, array));
    }

    /**
     * 超过时间限制
     */
    public int minSubArrayLen(int target, int[] nums) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(nums[0]);
        int right = 1;
        int minLen = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sumList(linkedList) < target) {
                linkedList.add(nums[right]);
                right++;
            } else {
                minLen = Math.min(minLen, linkedList.size());
                linkedList.removeFirst();
                while (sumList(linkedList) > target) {
                    minLen = Math.min(minLen, linkedList.size());
                    linkedList.removeFirst();
                }
            }
        }

        while (sumList(linkedList) >= target){
            minLen = Math.min(minLen, linkedList.size());
            linkedList.removeFirst();
        }

        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }

    public int sumList(LinkedList<Integer> linkedList) {
        int sum = 0;
        for (Integer i : linkedList) {
            sum += i;
        }
        return sum;
    }
}