package math;

import java.util.Arrays;
import java.util.HashSet;

/**
 * @author yidxue
 */
public class Code645 {
    public static void main(String[] args) {

    }

    public int[] findErrorNums(int[] nums) {
        int sum1 = (int) (0.5 * (1 + nums.length) * nums.length);
        HashSet<Integer> set = new HashSet<>();
        int sum2 = 0;
        int sum3 = 0;
        for (int i : nums) {
            if (!set.contains(i)) {
                set.add(i);
                sum2 += i;
            }
            sum3 += i;
        }

        return new int[]{sum1 - sum2, sum3 - sum2};
    }
}
