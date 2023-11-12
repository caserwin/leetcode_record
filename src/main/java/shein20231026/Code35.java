package shein20231026;

/**
 * User: caserwin
 * Date: 2023/11/12 11:22
 * Description:
 */
public class Code35 {

    public static void main(String[] args){
        int [] a = {1,3,5,6};
        int target = 2;
        System.out.println(searchInsert(a, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid]){
                return mid;
            }
            if (target < nums[mid]){
                right = mid-1;
            }

            if (target > nums[mid]){
                left = mid + 1;
            }
        }
        return -1;
    }

//
//    public int searchInsert1(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length -1;
//
//        while (left <= right) {
//            int index = (left + right) / 2;
//            if (nums[index] > target) {
//                right = index - 1;
//                continue;
//            }
//            if (nums[index] < target) {
//                left = index + 1;
//                continue;
//            }
//
//            if (nums[index] == target) {
//                return index;
//            }
//        }
//        return left;
//    }
}
