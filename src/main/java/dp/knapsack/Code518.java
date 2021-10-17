package dp.knapsack;

/**
 * @author yidxue
 */
public class Code518 {
    /**
     * 1. 对比第70题，爬楼梯。区别：第70题是求排列数，这一题是求组合数。[1,2],[2,1] 在这里中不做区分。
     * 2. 感觉和第 5 题也有点像。
     */
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {5, 1, 2};
        System.out.println(new Code518().change(amount, coins));
    }

    public int change(int amount, int[] coins) {
        // 表示兑换 amount 元钱，一共有多少种方法
        int[] dp = new int[amount + 1];

        // 初始化
        dp[0] = 1;

        // 转态转移
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
