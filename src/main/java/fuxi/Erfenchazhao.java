package fuxi;

/**
 * 1. 联立33：所有不确定要不要取到等号的地方都取等号
 * 2. left 和 right 分别通过 mid + 1 或 mid - 1 更新
 * 3. 和 34 题一起看
 */
public class Erfenchazhao {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 4, 5, 6, 7};

        System.out.println(new Erfenchazhao().search(nums, 0));
        System.out.println(new Erfenchazhao().search(nums, 1));
        System.out.println(new Erfenchazhao().search(nums, 2));
        System.out.println(new Erfenchazhao().search(nums, 4));
        System.out.println(new Erfenchazhao().search(nums, 6));
        System.out.println(new Erfenchazhao().search(nums, 7));
        System.out.println(new Erfenchazhao().search(nums, 3));
    }

    public int search(int[] nums, int target) {
        int i = 0;
        int j = nums.length - 1;
        if (target < nums[0] || target > nums[nums.length - 1]) {
            return -1;
        }

        while (i <= j) {
            int mid = (i + j) / 2;

            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                j = mid - 1;
            }
            if (nums[mid] < target) {
                i = mid + 1;
            }
        }
        return -1;
    }
}
