package dp.knapsack;

import java.util.Arrays;

/**
 * @author casyd_xue
 * 零钱兑换
 */
public class Code322 {

    public static void main(String[] args) {
//        int[] coins = {1};
//        int amount = 0;
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        int[] coins = {2};
        int amount = 3;
        System.out.println(new Code322().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        // dp[i] 表示零钱 i 需要的最少次数兑换
        int[] dp = new int[amount + 1];

        // 初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        // 转态转移
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
                }
            }
        }

        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}