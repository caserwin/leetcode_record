package special.nsum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/10/7 4:47 下午
 * Description: 三数之和
 *
 * @author yidxue
 */
public class Code15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        new Code15().threeSum(nums);
    }


    public List<List<Integer>> threeSum(int[] nums) {
        Integer[] newArray = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            newArray[i] = nums[i];
        }
        Arrays.sort(newArray, Comparator.naturalOrder());

        // 存放最终结果
        List<List<Integer>> resList = new ArrayList<>();
        // 存放中间结果
        List<Integer> tmpList;

        int target = 0;
        for (int i = 0; i < newArray.length; i++) {
            int tmpTarget = target - newArray[i];

            int left = i + 1;
            int right = newArray.length - 1;
            while (left < right) {
                if (newArray[left] + newArray[right] > tmpTarget) {
                    right--;
                    continue;
                }

                if (newArray[left] + newArray[right] < tmpTarget) {
                    left++;
                    continue;
                }

                if (newArray[left] + newArray[right] == tmpTarget) {
                    tmpList = new ArrayList<>();
                    tmpList.add(newArray[i]);
                    tmpList.add(newArray[left]);
                    tmpList.add(newArray[right]);
                    if (!resList.contains(tmpList)){
                        resList.add(tmpList);
                    }
                    left++;
                }
            }
        }
        return resList;
    }
}
