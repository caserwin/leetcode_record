package shein20231026;

/**
 * User: caserwin
 * Date: 2023/11/12 12:03
 * Description:
 */
public class Code33 {
    public static void main(String[] args){
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(search(nums, target));
    }
    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            // 如果 mid 左边有序
            if (nums[mid] >= nums[left]) {
                // 目标值位于有序部分
                if (nums[mid] > target && target >= nums[left]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            // 如果 mid 右边有序
            if (nums[mid] <= nums[right]) {
                // 目标值位于有序部分
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
