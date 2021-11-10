package tp;

/**
 * User: caserwin
 * Date: 2021/7/25 11:24 下午
 * Description:
 */
public class Code27 {
    public static void main(String[] args) {
        int[] nums = {2};
//        int[] nums = {3, 2, 2, 3};
        int val = 3;
        System.out.println(removeElement(nums, val));
        System.out.println(removeElementV2(nums, val));
    }

    /**
     * 双指针法，左右指针
     */
    public static int removeElementV2(int[] nums, int val) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (nums[left] != val) {
                left++;
                continue;
            }

            if (nums[right] == val) {
                right--;
                continue;
            }
            // 开始交换
            nums[left] = nums[right];
            nums[right] = val;
        }
        return left;
    }

    /**
     * TODO:  index = i 最后是等于i，而不是等于用于迭代的 j。
     */
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int length = 0;
        while (left < nums.length) {
            // 如果为val，要和后面第一个不为 val 的数值交换
            boolean is = false;
            if (nums[left] == val) {
                int right = left + 1;
                while (right < nums.length) {
                    if (nums[right] != val) {
                        nums[left] = nums[right];
                        nums[right] = val;
                        is = true;
                        break;
                    } else {
                        right++;
                    }
                }
                // 表示i 后面都是 val，没有可用于交换的
                if (!is) {
                    length = left;
                    break;
                }
            } else {
                length = left + 1;
            }
            left++;
        }
        return length;
    }
}
