package shein20231026;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * User: caserwin
 * Date: 2023/10/29 10:19
 * Description:
 */
public class Code55 {
    public boolean canJump(int[] nums) {
        // 是否能跳到以 i 为结尾的位置
        boolean[] dp = new boolean[nums.length-1];

        // 初始化
        Arrays.fill(dp, false);
        dp[0] = true;

        // 状态转移
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && nums[j]+ j >= i){
                    dp[i] = true;
                }
            }
        }
        return dp[nums.length-1];
    }
}
