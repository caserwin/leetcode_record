/**
 * User: caserwin
 * Date: 2021/7/25 11:09 下午
 * Description:
 */
public class Code35 {
    /**
     * TODO 记住：int right = nums.length -1，while (left <= right)等号是取到的
     */
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int index = (left + right) / 2;
            if (nums[index] > target) {
                right = index - 1;
                continue;
            }
            if (nums[index] < target) {
                left = index + 1;
                continue;
            }

            if (nums[index] == target) {
                return index;
            }
        }
        return left;
    }
}
