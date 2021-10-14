package special.jump;

/**
 * @author yidxue
 * 跳跃游戏2
 */
public class Code45 {
    public int jump(int[] nums) {
        // 表示跳到位置 i 需要最少的次数
        int[] dp = new int[nums.length];
        // 赋无穷大的初始值
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                // TODO 边界条件判断，一定是 >=
                if (nums[j] + j >= i) {
                    dp[i] = Math.min(dp[j] + 1, dp[i]);
                }
            }
        }
        return dp[nums.length - 1];
    }
}