package tp;

/**
 * @author casyd_xue
 */
public class Code209 {
    /**
     * 给定一个含有 n 个正整数的数组和一个正整数 s，找出该数组中满足其和 ≥ s 的长度最小的连续子数组。如果不存在符合条件的连续子数组，返回 0。
     * 示例: 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     * <p>
     * 首先我们移动R，使得滑动窗口的区间满足给定的条件，然后我们再移动L，直到滑动区间不再满足给定的条件，如此循环往复，并在其过程中记录最优值。
     */
    public static void main(String[] args) {
        int[] array = {2, 3, 1, 2, 4, 3};
        System.out.println(new Code209().minSubArrayLen(7, array));
    }

    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;

        // 记录最短长度
        int minLen = Integer.MAX_VALUE;
        int tmpSum = 0;
        while (right < nums.length) {
            // TODO 注意：这里直接先做 + 操作
            tmpSum += nums[right];
            if (tmpSum >= target) {
                minLen = Math.min(minLen, right - left + 1);
                tmpSum = tmpSum - nums[left];
                left++;
                while (left < right) {
                    if (tmpSum >= target) {
                        minLen = Math.min(minLen, right - left + 1);
                        tmpSum = tmpSum - nums[left];
                        left++;
                    } else {
                        right++;
                        break;
                    }
                }
            } else {
                right++;
            }
        }
        return minLen;
    }
}