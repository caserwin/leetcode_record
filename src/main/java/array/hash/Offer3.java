package array.hash;

/**
 * 数组中重复的数字
 * @author yidxue
 * 1. 就是把数组中的 value 放到对应的 数组[value] 下，不断交换顺序
 * 2. 本身就是把数组看成了一个 hash表
 */
public class Offer3 {
    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; ) {
            if (nums[i] == i) {
                i++;
                continue;
            }

            if (nums[nums[i]] == nums[i]) {
                return nums[i];
            }

            swap(nums, i, nums[i]);
        }
        return -1;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
