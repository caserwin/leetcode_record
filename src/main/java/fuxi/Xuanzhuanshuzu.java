package fuxi;

/**
 * 1. 联立 704 二分查找：所有不确定要不要取到等号的地方都取等号
 * 2. left 和 right 分别通过 mid + 1 或 mid - 1 更新
 */
public class Xuanzhuanshuzu {

    public static void main(String[] args) {
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;

        System.out.println(new Xuanzhuanshuzu().search(nums, target));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] >= nums[left]) {
                // 表示 left -mid 这部分是升序的，且 mid- right 这部分是经过旋转的
                if (nums[mid] >= target && target >= nums[left]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                // 表示 left -mid 这部分是经过旋转的，且 mid- right 这部分是升序的
                if (nums[mid] <= target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }

            }
        }
        return -1;
    }
}
