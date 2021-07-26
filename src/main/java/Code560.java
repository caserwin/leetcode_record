/**
 * User: caserwin
 * Date: 2021/7/26 12:26 下午
 * Description:
 */
public class Code560 {

    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            // 表示以 i 为起始位置的子数组的求和
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    count++;
                }
            }
        }
        return count;
    }
}
