package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/27 08:32
 * Description:
 */
public class Code42 {
    public static void main(String[] args){
        int[] height ={4,2,0,3,2,5};
        System.out.println(trap(height));
    }
    public static int trap(int[] height) {
        int[] left = new int[height.length];
        int[] right = new int[height.length];

        left[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(left[i-1], height[i]);
        }

        right[height.length-1] = height[height.length-1];
        for (int i = height.length -2; i >= 0; i--) {
            right[i] = Math.max(right[i+1], height[i]);
        }

        int res = 0;
        for (int i = 0; i < height.length; i++) {
            res += Math.min(left[i], right[i]) - height[i];
        }
        return res;
    }
}
