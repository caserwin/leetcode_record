package special.bs;

/**
 * 1. 联立33：所有不确定要不要取到等号的地方都取等号
 * 2. left 和 right 分别通过 mid + 1 或 mid - 1 更新
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
