package shein20231026;

import java.util.Arrays;

/**
 * User: caserwin
 * Date: 2023/10/31 23:28
 * Description:
 */
public class Code322 {
    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示凑成 i 面额最小硬币数
        int[] dp = new int[amount+1];

        // 初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int coin : coins) {
            dp[coin] = 1;
        }

        // 状态转移
        for (int i = 1; i < amount; i++) {
            for (int coin : coins) {
                if (i > coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE? -1: dp[amount];
    }
}
