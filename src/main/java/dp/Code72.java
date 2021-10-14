package dp;

//import array.ArrayUtil;

/**
 * @author casyd_xue
 */
public class Code72 {

    public static void main(String[] args) {
        String s1 = "horse";
        String s2 = "ros";
        new Code72().minDistance(s1, s2);
    }

    public int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();

        // 1. 定义 dp[i][j] 表示 word1[0:i] 和 word2[0:j] 的编辑距离
        int[][] dp = new int[len1 + 1][len2 + 1];

        // 2. 初始化
        dp[0][0] = 0;
        for (int i = 1; i < len1 + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j < len2 + 1; j++) {
            dp[0][j] = j;
        }

        // 3. 状态转移
        for (int i = 1; i < len1 + 1; i++) {
            for (int j = 1; j < len2 + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }

//        ArrayUtil.printMatrix(dp);
        return dp[len1 - 1][len2 - 1];
    }
}