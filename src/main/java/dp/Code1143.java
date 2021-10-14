package dp;

/**
 * @author casyd_xue
 * 最长公共子序列
 */
public class Code1143 {
    public static void main(String[] args) {
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        System.out.println(new Code1143().longestCommonSubsequence(text1, text2));
    }

    public int longestCommonSubsequence(String text1, String text2) {
        // 表示text1 的[0,i]。text2 的[0,j] 的公共最长子序列
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];

        // 初始化
        dp[0][0] = 0;
        for (int j = 1; j < text2.length() + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < text1.length() + 1; i++) {
            dp[i][0] = 0;
        }

        // 状态转移
        for (int i = 1; i < text1.length() + 1; i++) {
            for (int j = 1; j < text2.length() + 1; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[text1.length()][text2.length()];
    }
}