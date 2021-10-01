package dp;

/**
 * User: caserwin
 * Date: 2021/8/8 4:30 下午
 * Description:
 *
 * @author yidxue
 */
public class Code62 {
    public static void main(String[] args) {

    }

    public int uniquePaths(int m, int n) {
        // 从 0,0 开始到以 m,n 为终点的一共有多少条路径
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < n; i++) {
            dp[0][n] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m-1][n-1];
    }
}
