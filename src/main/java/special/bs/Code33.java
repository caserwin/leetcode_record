package special.bs;

/**
 * @author yidxue
 * 搜索旋转排序数组：基于二分法
 */
public class Code33 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new Code33().search(nums, target));
    }

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // TODO 判断 0 到mid 位置是升序的，且这个等号必须取到，否则 nums=[3,1] target=1 这个case 过不了
            if (nums[mid] >= nums[0]) {
                if (nums[mid] > target && target >= nums[0]) {
                    // 如果 target 数字在升序部分
                    right = mid - 1;
                } else {
                    // 如果 target 数字在乱序部分
                    left = mid + 1;
                }
            } else {
                // 说明 mid 到 结束位置是升序的
                if (nums[nums.length - 1] >= target && target > nums[mid]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}
