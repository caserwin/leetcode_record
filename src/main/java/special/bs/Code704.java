package special.bs;

/**
 * User: caserwin
 * Date: 2021-07-24 21:26
 * Description:
 */
public class Code704 {

    public static void main(String[] args) {
        int[] arr = {5};
        int target = -5;
        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int mid = nums.length / 2;

        while (left <= right) {
            if (target == nums[mid]) {
                return mid;
            }

            // 注意这里是 index + 1
            if (target > nums[mid]) {
                left = mid + 1;
            }

            // 注意这里是 index - 1
            if (target < nums[mid]) {
                right = mid - 1;
            }

            mid = (left + right) / 2;
        }
        return -1;
    }
}
