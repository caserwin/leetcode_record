package special.bs;

/**
 * @author casyd_xue
 * 这个还有错误
 */
public class Code153 {
    public static void main(String[] args) {
        int[] nums = {3, 1, 2};
        System.out.println(new Code153().findMin(nums));
    }

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (left == right) {
                break;
            }
            int mid = (left + right) / 2;
            if (nums[mid] > nums[0] && nums[mid] > nums[nums.length - 1]) {
                // 说明 nums[0:mid] 是升序的，同时nums [mid: nums.length - 1] 是乱序的
                left = mid + 1;
            } else if (nums[mid] >= nums[0] && nums[mid] <= nums[nums.length - 1]) {
                // 说明全部都是升序的
                return nums[0];
            } else if (nums[0] >= nums[mid] && nums[mid] >= nums[nums.length - 1]) {
                // 说明都是逆序的
                return nums[nums.length - 1];
            } else {
                // 说明 nums[0:mid] 是乱序，要从 0 到 mid 找
                right = mid - 1;
            }
        }
        return nums[left];
    }
}
