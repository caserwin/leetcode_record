package special.knapsack;

import java.util.Arrays;

/**
 * @author casyd_xue
 * 零钱兑换
 */
public class Code322 {

    public static void main(String[] args) {
        int[] coins = {1};
        int amount = 0;
//        int[] coins = {1, 2, 5};
//        int amount = 11;
        System.out.println(new Code322().coinChange(coins, amount));
    }

    public int coinChange(int[] coins, int amount) {
        // 表示零钱 i 需要的最少次数兑换
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        // 初始化动态规划数值 dp，其实以下都不用的，官方解答直接是 dp[0] = 0;
        // 这里我还是这么写，比较符合一般人理解吧
        for (int coin : coins) {
            if (coin >= dp.length) {
                continue;
            }
            dp[coin] = 1;
        }
        dp[0] = 0;

        // 转态转移
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i >= coin && dp[i - coin] != Integer.MAX_VALUE && dp[i - coin] != 0) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
    }
}