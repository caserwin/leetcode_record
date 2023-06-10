package fuxi;

/**
 * User: caserwin
 * Date: 2023/6/10 11:54 上午
 * Description:
 */
public class Yidonglin {
    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        new Yidonglin().moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public void moveZeroes(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            // 如果等于 0 则和后面最近一个非0元素交换位置。
            if (nums[i] == 0) {
                int j = i + 1;
                while (j < nums.length) {
                    if (nums[j] != 0) {
                        break;
                    }
                    j++;
                }
                if (j < nums.length){
                    swap(nums, i, j);
                }
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}
