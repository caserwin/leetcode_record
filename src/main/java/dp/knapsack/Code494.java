package dp.knapsack;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * @author yidxue
 * 和前缀和 《code560-和为k的子数组个数》类似，都要通过公式变换求解。
 */
public class Code494 {

    public int findTargetSumWays1(int[] nums, int target) {
        // 求和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        // neg 为前面是 -1 的元素和，sum-neg 是前面为 1 的元素和。 sum-neg -neg = target
        int neg = (sum - target) / 2;

        // 如果不是偶数则跳出
        if (neg != (float) (sum - target) / 2) {
            return -1;
        }

        // dp[i][j] 表示用前 i 个元素做选择，凑成数字 j 的方法数。 0-1 背包
        int[][] dp = new int[nums.length][neg + 1];

        // 初始化
        for (int i = 0; i < nums.length; i++) {
            dp[i][0] = 1;
        }
        dp[0][nums[0]] = 1;

        // 转态转移
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < neg + 1; j++) {
                dp[i][j] = dp[i - 1][j];
                if (nums[i] <= j) {
                    dp[i][j] += dp[i][j - nums[i]];
                }
            }
        }

        return dp[nums.length - 1][neg];
    }

    /**
     *
     */
    public int findTargetSumWays(int[] nums, int target) {
        // 记录结果
        ArrayList<LinkedList<Integer>> res = new ArrayList<>();
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        // 开始回溯
        dfs(res, track, nums, target);

        return res.size();
    }

    private void dfs(ArrayList<LinkedList<Integer>> res, LinkedList<Integer> track, int[] nums, int target) {
        if (track.size() == nums.length && sumBool(track, nums, target)) {
            res.add(new LinkedList<>(track));
            return;
        }

        if (track.size() > nums.length) {
            return;
        }

        track.add(1);
        dfs(res, track, nums, target);
        track.removeLast();

        track.add(-1);
        dfs(res, track, nums, target);
        track.removeLast();
    }

    public boolean sumBool(LinkedList<Integer> track, int[] nums, int target) {
        if (track.size() != nums.length) {
            return false;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += track.get(i) * nums[i];
        }
        return sum == target;
    }
}
