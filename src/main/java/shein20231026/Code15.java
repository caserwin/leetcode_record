package shein20231026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/10/30 08:25
 * Description:
 */
public class Code15 {
    public static void main(String[] args){
        int[] nums ={1,2,-2,-1};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                if (nums[j] + nums[k] > -nums[i]) {
                    k--;
                    continue;
                }

                if (nums[j] + nums[k] == -nums[i] && j !=k && j!=i && k!=i) {
                    List<Integer> tmpLs = new ArrayList<>();
                    tmpLs.add(nums[i]);
                    tmpLs.add(nums[j]);
                    tmpLs.add(nums[k]);
                    res.add(tmpLs);
                    j++;
                }

                if (nums[j] + nums[k] < -nums[i]) {
                    j++;
                }
            }
        }
        return res;
    }
}
