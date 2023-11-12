package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/29 10:53
 * Description:
 */
public class Code72 {
    public static void main(String[] args){
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(minDistance1(word1, word2));
    }

    public static int minDistance1(String word1, String word2) {

        char[] cs1 = word1.toCharArray();
        char[] cs2 = word2.toCharArray();

        // dp[i][j] 表示从字符 word1[0:i] -> word1[0:j] 的编辑距离
        int[][] dp = new int[cs1.length + 1][cs2.length + 1];

        // 初始化
        dp[0][0] = 0;
        for (int i = 1; i < cs1.length + 1 ; i++) {
            dp[i][0] = dp[i-1][0] + 1;
        }
        for (int j = 1; j < cs2.length + 1; j++) {
            dp[0][j] = dp[0][j-1] + 1;
        }

        // 转态转移
        for (int i = 1; i < cs1.length+1; i++) {
            for (int j = 1; j < cs2.length+1; j++) {
                if (cs1[i-1] == cs2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[cs1.length][cs2.length];
    }
}
