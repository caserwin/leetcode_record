package dfs;

import java.util.Arrays;

/**
 * @author yidxue
 * K 站中转内最便宜的航班
 */
public class Code787 {

    public static void main(String[] args) {
        int n = 3;
        int[][] edges = {{0, 1, 100}, {1, 2, 100}, {0, 2, 500}};
        int src = 0, dst = 2, k = 1;
        System.out.println(new Code787().findCheapestPrice(n, edges, src, dst, k));
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        final int INF = 10000 * 101 + 1;
        // f[t][i] 表示通过恰好 t 次航班，从出发城市 src 到达城市 i 需要的最小花费。
        int[][] dp = new int[k + 2][n];

        // 初始化
        for (int i = 0; i < k + 2; ++i) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][src] = 0;

        // 状态转移
        for (int t = 1; t <= k + 1; ++t) {
            for (int[] flight : flights) {
                int j = flight[0], i = flight[1], cost = flight[2];
                dp[t][i] = Math.min(dp[t][i], dp[t - 1][j] + cost);
            }
        }

        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, dp[t][dst]);
        }

        return ans == INF ? -1 : ans;
    }
}
