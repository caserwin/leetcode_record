package dp;

import baisc.ArrayUtil;

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
        // dp[i][j] 表示从 src 出发，经过 i 次航班，到达城市 j 的最小花费。下面之所以是 k+2，是因为k 次周转，要经过 k+1 个航班，所以初始化为 k+2 长度（从0开始）。
        int[][] dp = new int[k + 2][n];

        // 初始化，因为要求最小，所以默认初始化长度都是最大
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

//        ArrayUtil.printMatrix(dp);

        int ans = INF;
        for (int t = 1; t <= k + 1; ++t) {
            ans = Math.min(ans, dp[t][dst]);
        }

        return ans == INF ? -1 : ans;
    }
}
