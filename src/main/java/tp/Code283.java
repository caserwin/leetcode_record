package tp;

/**
 * @author yidxue
 * 移动0，保持非零元素相对位置，和26题解法一致。
 */
public class Code283 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 3, 12};
        new Code283().moveZeroes1(nums);
    }

    /**
     * 双指正-快慢指针技巧
     */
    public void moveZeroes1(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            // 如果当前元素非 0，则交换到左边
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }

    /**
     * 和 code 26， 27 异曲同工，两个指针实现即可
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        while (left < nums.length) {
            // 与第一个非0元素交换位置
            if (nums[left] == 0) {
                int right = left + 1;
                boolean is = false;
                while (right < nums.length) {
                    if (nums[right] != 0) {
                        nums[left] = nums[right];
                        nums[right] = 0;
                        is = true;
                        break;
                    } else {
                        right++;
                    }
                }

                if (!is) {
                    break;
                }
            }
            left++;
        }
    }
}
