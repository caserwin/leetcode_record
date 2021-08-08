package dongtaiguihua;

/**
 * User: caserwin
 * Date: 2021/8/8 5:43 下午
 * Description:
 */
public class Code198 {

    public int rob(int[] nums) {
        if (nums.length == 0){
            return 0;
        }
        if (nums.length == 1){
            return nums[0];
        }

        if (nums.length == 2){
            return Math.max(nums[0], nums[1]);
        }

        // 用dp 记录前 i 间房屋能偷窃到的最高总金额
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[nums.length - 1];
    }
}