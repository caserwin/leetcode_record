package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/28 23:52
 * Description:
 */
public class Code53 {
    public int maxSubArray(int[] nums) {

        // 以 i 为结尾的最大子数组和
        int[] dp = new int[nums.length];

        dp[0] = nums[0];
        int maxRes = dp[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i-1] + nums[i], nums[i]);
            maxRes = Math.max(dp[i], maxRes);
        }
        return maxRes;
    }
}
