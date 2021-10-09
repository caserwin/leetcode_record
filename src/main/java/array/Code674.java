package array;

/**
 * @author yidxue
 * 最长连续递增序列
 */
public class Code674 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 4, 2, 3, 4, 5};
        new Code674().findLengthOfLCIS(nums);
    }

    public int findLengthOfLCIS(int[] nums) {
        int maxLen = 0;
        // 注意：初始的长度应该是1。
        int tmp = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > last) {
                tmp++;
            } else {
                maxLen = Math.max(maxLen, tmp);
                tmp = 1;
            }
            last = nums[i];
        }
        // 最后跳出来还要取一次最大值
        maxLen = Math.max(maxLen, tmp);
        return maxLen;
    }
}
