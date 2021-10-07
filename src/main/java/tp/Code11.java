package tp;

/**
 * User: caserwin
 * Date: 2021-07-25 17:17
 * Description:
 */
public class Code11 {

    public static void main(String[] args) {
        int[] a = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(maxArea(a));
    }

    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxNum = 0;

        while (right > left) {
            int tmp = (right - left) * Math.min(height[right], height[left]);
            maxNum = Math.max(maxNum, tmp);

            if (height[right] >= height[left]) {
                left++;
            } else {
                right--;
            }
        }
        return maxNum;
    }
}
