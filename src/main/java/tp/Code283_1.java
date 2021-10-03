package tp;

/**
 * User: caserwin
 * Date: 2021/7/26 5:28 下午
 * Description:
 */
public class Code283_1 {

    /**
     * 和 code 26， 27 异曲同工，两个指针实现即可
     */
    public void moveZeroes(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (right != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
