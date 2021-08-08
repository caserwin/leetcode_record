package dongtaiguihua;

import com.sun.tools.javac.jvm.Code;

/**
 * User: caserwin
 * Date: 2021/8/8 4:59 下午
 * Description:
 *
 * @author yidxue
 */
public class Code53 {

    public static void main(String[] args) {
        int[] a = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(new Code53().maxSubArray(a));
    }

    public int maxSubArray(int[] nums) {
        // 表示以 i 为结尾的子数组的最大和
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int num : dp) {
            max = Math.max(num, max);
        }
        return max;
    }
}
