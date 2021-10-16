package dp;

/**
 * @author yidxue
 * 打家劫舍
 */
public class Code198 {

    public static void main(String[] args) {
        int[] nums = {0};
        System.out.println(new Code198().rob(nums));
    }

    public int rob(int[] nums) {
        // 边界条件判断
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 定义 dp[i] 是到底 i-1 家为止，最大能抢到的钱
        int[] dp = new int[nums.length];

        // 初始化
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        // 状态转移
        for (int i = 2; i < nums.length; i++) {
            // 如果第 i 家不偷，那么到当前为止偷的最大值是 dp[i - 1]，如果第 i 家偷了，则最大值是 dp[i - 1] + num[i]
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[nums.length - 1];
    }
}
