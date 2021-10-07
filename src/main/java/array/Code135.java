package array;

import java.util.Arrays;

/**
 * @author yidxue
 */
public class Code135 {

    /**
     * 1. 遍历两次，一次填 left 数组，一次填 right 数组
     * 2. 从左到右遍历时，如果i+1 大于 i，则left[i+1] = left[i]，否则left[i+1] 不变。
     * 3. 从右到左遍历时，如果i-1 大于 i，则right[i-1] = 则right[i]+1，否则right[i-1] 不变。
     */
    public int candy(int[] ratings) {
        int[] left = new int[ratings.length];
        int[] right = new int[ratings.length];

        Arrays.fill(left, 1);
        Arrays.fill(right, 1);

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        for (int i = 1; i < ratings.length; i++) {
            if (ratings[ratings.length - i] < ratings[ratings.length - i - 1]) {
                right[ratings.length - i - 1] = right[ratings.length - i] + 1;
            }
        }

        int count = 0;
        for (int i = 0; i < left.length; i++) {
            count += Math.max(left[i], right[i]);
        }
        return count;
    }
}
