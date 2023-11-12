package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/26 23:52
 * Description:
 */
public class Code704 {

    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right){
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
}
