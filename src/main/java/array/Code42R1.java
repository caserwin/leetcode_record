package array;

/**
 * 接雨水，和 Code 135 很像，都是遍历两次，用left 和right 数组的公共部分
 * https://leetcode-cn.com/problems/trapping-rain-water/
 */
public class Code42R1 {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(new Code42R1().trap(height));
    }

    public int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }

        right[height.length - 1] = height[height.length - 1];
        for (int j = height.length - 2; j >= 0; j--) {
            right[j] = Math.max(height[j], right[j + 1]);
        }

        int sum = 0;
        for (int i = 0; i < height.length; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }

        return sum;
    }
}
