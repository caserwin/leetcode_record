package dp;

/**
 * @author yidxue
 * 打家劫舍2：
 * 核心：第一个房子和最后一个房子中只能选择一个偷窃，因此可以把这个问题分为两个 198 的子问题。
 * 1. 第一家如果偷了情况下的 198 题目
 * 2. 第一家如果不偷情况下的 198 题目
 */
public class Code213 {
    public static void main(String[] args) {
        int[] nums = {4, 1, 2, 7, 5, 3, 1};
        System.out.println(new Code213().rob(nums));
    }

    public int rob(int[] nums) {
        // 边界条件判断
        if (nums.length == 1) {
            return nums[0];
        }

        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // 假设第一家偷了，定义 dp1[i] 是到底 i-1 家为止，最大能抢到的钱。
        int[] dp1 = new int[nums.length];
        // 假设第一家没偷，定义 dp2[i] 是到底 i-1 家为止，最大能抢到的钱。
        int[] dp2 = new int[nums.length];

        // 初始化
        dp1[0] = nums[0];
        // 因为第一家偷，所以第二家肯定不能偷了，所以有 dp1[1] = dp1[0]
        dp1[1] = dp1[0] ;
        // 因为第一家偷，所以最后一家也不能偷，特殊标记下
        dp1[nums.length - 1] = Integer.MIN_VALUE;

        // 因为第一家没偷，所以第二家肯定要偷才行
        dp2[0] = 0;
        dp2[1] = nums[1];

        // 状态转移
        for (int i = 2; i < nums.length; i++) {
            // 如果是特殊标记，表示当前家不能偷，dp1[i] = dp1[i - 1];
            if (dp1[i] == Integer.MIN_VALUE) {
                dp1[i] = dp1[i - 1];
            } else {
                dp1[i] = Math.max(dp1[i - 1], dp1[i - 2] + nums[i]);
            }
            dp2[i] = Math.max(dp2[i - 1], dp2[i - 2] + nums[i]);
        }

        return Math.max(dp1[nums.length - 1], dp2[nums.length - 1]);
    }
}
