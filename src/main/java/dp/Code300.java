package dp;

import java.util.Arrays;

/**
 * @author yidxue
 */
public class Code300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new Code300().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        // 定义dp[i] 是以第 i 个数字结尾的最长上升子序列的长度
        int[] dp = new int[nums.length];

        // 初始化，这里是个要注意的点
        Arrays.fill(dp, 1);

        // 转态转移
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
        }

        // 寻找符合条件的返回值
        int len = 0;
        for (int j : dp) {
            len = Math.max(len, j);
        }
        return len;
    }
}
