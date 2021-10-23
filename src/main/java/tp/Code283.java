package tp;

/**
 * @author yidxue
 * 移动0，保持非零元素相对位置，和26题解法一致。
 */
public class Code283 {

    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 0, 3, 12};
        new Code283().moveZeroes4(nums);

        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int[] moveZeroes4(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }

            int tmp = i + 1;
            while (tmp < nums.length) {
                if (nums[tmp] != 0) {
                    nums[i] = nums[tmp];
                    nums[tmp] = 0;
                    break;
                }
                tmp++;
            }
        }

        return nums;
    }


    /**
     * 单指针
     */
    public int[] moveZeroes3(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                continue;
            }
            int j = i;
            while (j < nums.length) {
                if (nums[j] != 0) {
                    nums[i] = nums[j];
                    nums[j] = 0;
                    break;
                }
                j++;
            }
        }
        return nums;
    }

    /**
     * 双指针
     */
    public int[] moveZeroes2(int[] nums) {
        int slow = 0;
        int fast = 0;

        while (fast < nums.length) {
            // 一直把 slow、fast 移到出现0 的地方
            if (nums[slow] != 0) {
                slow++;
                fast = Math.max(fast, slow);
                continue;
            }

            if (nums[fast] != 0 && nums[slow] == 0) {
                int tmp = nums[fast];
                nums[fast] = nums[slow];
                nums[slow] = tmp;
            }

            fast++;
        }
        return nums;
    }

    /**
     * 官方解答
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