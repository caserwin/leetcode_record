package dongtaiguihua;

/**
 * User: caserwin
 * Date: 2021/8/8 4:39 下午
 * Description:
 */
public class Code64 {
    public static void main(String[] args) {

    }

    public int minPathSum(int[][] grid) {
        int a = grid.length;
        int b = grid[0].length;
        // 用dp[][] 表示从 0,0 到 i,j 的最小路径和
        int[][] dp = new int[a][b];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < a; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < b; i++) {
            dp[0][i] = dp[0][i-1] + grid[0][i];
        }

        for (int i = 1; i < a; i++) {
            for (int j = 1; j < b; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[a - 1][b - 1];
    }
}
