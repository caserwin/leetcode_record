package dp;

/**
 * @author yidxue
 */
public class Code70 {
    public static int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        int[] num = new int[n + 1];
        num[1] = 1;
        num[2] = 2;
        for (int i = 3; i < num.length; i++) {
            num[i] = num[i - 1] + num[i - 2];
        }
        return num[n];
    }
}
