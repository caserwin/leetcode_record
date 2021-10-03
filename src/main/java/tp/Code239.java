package tp;

/**
 * User: caserwin
 * Date: 2021/10/2 2:45 下午
 * Description:
 */
public class Code239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        //右边起始位置
        int right = k - 1;

        if (k - 1 >= nums.length) {
            // 求 nums 中最大值即可
            int max = Integer.MIN_VALUE;
            for (int num : nums) {
                max = Math.max(max, num);
            }
            return new int[]{max};
        }

        int[] res = new int[nums.length - k + 1];
        int tmpNum;
        while (right < nums.length) {
            tmpNum = getRangeMax(left, right, nums);
            res[left] = tmpNum;
            right++;
            left++;
        }
        return res;
    }

    private int getRangeMax(int left, int right, int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i = left; i <= right; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
}
