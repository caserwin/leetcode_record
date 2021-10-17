package array;

/**
 * 接雨水，和 Code 135 很像，都是遍历两次，用left 和right 数组的公共部分
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Code42 {

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        int leftTmpMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftTmpMax = Math.max(leftTmpMax, height[i]);
            if (height[i] <= leftTmpMax) {
                left[i] = leftTmpMax;
            }
        }

        int rightTmpMax = 0;
        for (int i = 0; i < height.length; i++) {
            rightTmpMax = Math.max(rightTmpMax, height[height.length - i - 1]);
            if (rightTmpMax >= height[height.length - i - 1]) {
                right[height.length - i - 1] = rightTmpMax;
            }
        }

        int[] res = new int[height.length];
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            res[i] = Math.min(left[i], right[i]);
            sum += res[i] - height[i];
        }
        return sum;
    }
}
