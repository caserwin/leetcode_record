package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author casyd_xue
 * 找到所有数组中消失的数字
 */
public class Code448 {

    /**
     * 借用桶排序的方式实现
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        int[] numArr = new int[n];

        for (int num : nums) {
            numArr[num - 1] = 1;
        }

        for (int i = 0; i < numArr.length; i++) {
            if (numArr[i] == 0) {
                list.add(i + 1);
            }
        }

        return list;
    }
}