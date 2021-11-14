package dp.knapsack;

/**
 * 416 分割等和子集
 * https://leetcode-cn.com/problems/partition-equal-subset-sum/solution/0-1-bei-bao-wen-ti-xiang-jie-zhen-dui-ben-ti-de-yo/
 * 核心：
 *      1. 是否可以从输入数组中挑选出一些正整数，使得这些数的和 等于 整个数组元素的和的一半。
 *      2. 就是 leetcode 40 的组合问题
 *
 * @author yidxue
 */
public class Code416 {
    public static void main(String[] args) {
//        int[] nums = {1, 1};
        int[] nums = {1, 5, 11, 5};
//        int[] nums = {1, 2, 5};
//        int[] nums = {100};
        System.out.println(new Code416().canPartition(nums));
    }

    public boolean canPartition(int[] nums) {
        int len = nums.length;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // 边界条件判断
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;
        // 定义dp[i][j]: 表示从 nums[0:i] 范围做选择，是否存在一种选取方案使得被选取的元素和等于 j。
        boolean[][] dp = new boolean[len][target + 1];

        // 初始化：因为候选数 nums[0] 是正整数，凑不出和为 0；
        for (int i = 0; i < len; i++) {
            dp[i][0] = true;
        }

        // 转态转移
        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[len - 1][target];
    }
}
