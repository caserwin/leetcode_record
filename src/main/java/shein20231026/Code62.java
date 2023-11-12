package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/29 10:34
 * Description:
 */
public class Code62 {
    public int uniquePaths(int m, int n) {
        // dp[i][j] 表示从 0,0 -> i,j 一共有多少种走法
        int[][] dp = new int[m][n];

        //初始化
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 转态转移
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
