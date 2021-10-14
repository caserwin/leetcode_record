package dp;

import java.util.Arrays;

/**
 * @author casyd_xue
 * 279：完全平方数
 */
public class Code279 {
    /**
     * 动态规划：官方解答
     */
    public static void main(String[] args) {
        int num = 12;
        System.out.println(new Code279().numSquares(num));
    }


    public int numSquares(int n) {
        // dp[i] 表示元素 i 的完全平方数最少数量
        int[] dp = new int[n + 1];

        // 初始化
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        dp[1] = 1;

        // 状态转移，这里是能取到等号的
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= (int) Math.sqrt(i); j++) {
                int tmp = (int) Math.pow(j, 2);
                dp[i] = Math.min(dp[i], dp[i - tmp] + 1);
            }
        }

        return dp[n];
    }
}