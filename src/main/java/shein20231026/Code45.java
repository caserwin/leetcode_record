package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/27 08:43
 * Description:
 */
public class Code45 {
    public static void main(String[] args){
        int[] nums ={2,3,1,1,4};
        System.out.println(jump(nums));
    }
    public static int jump(int[] nums) {

        int[] dp = new int[nums.length];
        // 赋无穷大的初始值
        for (int i = 0; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] != Integer.MAX_VALUE && nums[j] +j >=i){
                    dp[i] = Math.min( dp[i],  dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];
    }
}
