package dp;

/**
 * @author casyd_xue
 * 最长公共子串
 */
public class Code718 {

    public static void main(String[] args) {
        int[] nums1 = {0, 1, 1, 1};
        int[] nums2 = {1, 0, 1, 0, 1};
        new Code718().findLength(nums1, nums2);
    }

    public int findLength(int[] nums1, int[] nums2) {
        int len1 = nums1.length + 1;
        int len2 = nums2.length + 1;

        //定义数组：表示以 i,j 为结尾的子数组长度
        int[][] dp = new int[len1][len2];

        // 初始化
        for (int i = 0; i < len1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < len2; j++) {
            dp[0][j] = 0;
        }

        // 状态转移
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                max = Math.max(max, dp[i][j]);
            }
        }
        return max;
    }
}