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

        int index = nums.length / 2;
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            if (target == nums[index]) {
                return index;
            }

            // 注意这里是 index + 1
            if (target > nums[index]) {
                left = index + 1;
            }

            // 注意这里是 index - 1
            if (target < nums[index]) {
                right = index - 1;
            }

            index = (left + right) / 2;
        }
        return -1;
    }
}
