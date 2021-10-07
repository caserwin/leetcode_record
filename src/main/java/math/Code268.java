package math;

/**
 * @author yidxue
 */
public class Code268 {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        double sum = 0.5 * n * (1 + n);
        for (int num : nums) {
            sum = sum - num;
        }
        return (int) sum;
    }
}
