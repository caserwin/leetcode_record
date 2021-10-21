package array;

/**
 * User: caserwin
 * Date: 2021/10/20 8:36 上午
 * Description:
 */
public class Code453 {
    public int minMoves(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (Integer num : nums) {
            min = Math.min(min, num);
        }
        int operNum = 0;
        for (Integer num : nums) {
            operNum += num - min;
        }
        return operNum;
    }
}
