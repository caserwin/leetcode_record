package special.bs;

/**
 * @author yidxue
 * 1. 联立 704 二分查找：所有不确定要不要取到等号的地方都取等号
 * 2. left 和 right 分别通过 mid + 1 或 mid - 1 更新
 */
public class Code33 {
    public static void main(String[] args) {
        int[] nums = {3, 1};
        int target = 1;
        System.out.println(new Code33().search2(nums, target));
    }

//    public int search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        while (left <= right) {
//            int mid = (left + right) / 2;
//
//            if (nums[mid] == target) {
//                return mid;
//            }
//
//            // TODO 判断 0 到mid 位置是升序的，且这个等号必须取到，否则 nums=[3,1] target=1 这个case 过不了
//            if (nums[mid] >= nums[0]) {
//                if (nums[mid] > target && target >= nums[0]) {
//                    // 如果 target 数字在升序部分
//                    right = mid - 1;
//                } else {
//                    // 如果 target 数字在乱序部分
//                    left = mid + 1;
//                }
//            } else {
//                // 说明 mid 到 结束位置是升序的
//                if (nums[nums.length - 1] >= target && target > nums[mid]) {
//                    left = mid + 1;
//                } else {
//                    right = mid - 1;
//                }
//            }
//        }
//        return -1;
//    }

    /**
     * 通过测评
     */
    public int search2(int[] nums, int target) {
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
