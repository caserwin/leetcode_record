package dongtaiguihua;

/**
 * User: caserwin
 * Date: 2021/8/8 5:15 下午
 * Description:
 */
public class Code152 {
    public static void main(String[] args){

    }
    public int maxProduct(int[] nums) {
        // 本质上要有两个dp 数组。一个记录以 i 结尾的最大累乘值。一个记录以 i 结尾的最小累乘值。
        int[] imax = new int[nums.length];
        int[] imin = new int[nums.length];

        imax[0] = nums[0];
        imin[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            imax[i] = Math.max(Math.max(imax[i-1] * nums[i],  imin[i-1] * nums[i]), nums[i]);
            imin[i] = Math.min(Math.min(imax[i-1] * nums[i],  imin[i-1] * nums[i]), nums[i]);
        }

        int max = Integer.MIN_VALUE;
        for (int num : imax) {
            max = Math.max(num, max);
        }
        return max;
    }
}
