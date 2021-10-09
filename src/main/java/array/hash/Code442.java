package array.hash;

import java.util.ArrayList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/10/9 10:59 上午
 * Description:
 */
public class Code442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < nums.length; ) {
            if (nums[i] - 1 == i) {
                i++;
                continue;
            }

            // 这里是核心点1
            if (nums[nums[i] - 1] == nums[i]) {
                // 这里是一个易错点，调试之后才加上
                if (!list.contains(nums[i])) {
                    list.add(nums[i]);
                }
                i++;
                continue;
            }

            swap(nums, i, nums[i] - 1);
        }
        return list;
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
