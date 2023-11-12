//package shein20231026;
//
///**
// * User: caserwin
// * Date: 2023/11/12 12:25
// * Description:
// */
//public class Code153 {
//    public int findMin(int[] nums) {
//        int left = 0;
//        int right = nums.length - 1;
//
//        while (left <= right) {
//            int mid = (left + right) / 2;
//            if (nums[mid] <= nums[right] && nums[mid] < nums[left]) {
//                return mid;
//            }
//            // 如果 mid 左边有序
//            if (nums[mid] >= nums[left]) {
//                if (nums[mid] > target && target >= nums[left]) {
//                    right = mid - 1;
//                }else {
//                    left = mid + 1;
//                }
//            }
//            // 如果 mid 右边有序
//            if (nums[mid] <= nums[right]) {
//                if (nums[mid] < target && target <= nums[right]) {
//                    left = mid + 1;
//                }else {
//                    right = mid - 1;
//                }
//            }
//        }
//        return -1;
//    }
//}
