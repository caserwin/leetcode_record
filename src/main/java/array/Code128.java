package array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @author yidxue
 * 最长连续序列
 */
public class Code128 {
    public static void main(String[] args) {
//        int[] nums = {0, -1};
        int[] nums = {100, 4, 200, 1, 3, 2};
        System.out.println(new Code128().longestConsecutive(nums));
    }

    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // 用于记录哪些判断过的
        Set<Integer> recordSet = new HashSet<>();

        int maxLen = Integer.MIN_VALUE;
        for (int num : nums) {
            if (recordSet.contains(num)) {
                continue;
            }
            int j = num;
            int tmpLen = 0;
            while (numSet.contains(j)) {
                j++;
                tmpLen++;
                recordSet.add(j);
            }
            maxLen = Math.max(maxLen, tmpLen);
        }
        return maxLen;
    }
}
