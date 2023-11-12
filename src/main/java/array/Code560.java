package array;

import java.util.HashMap;

/**
 * User: caserwin
 * Date: 2021/7/26 12:26 下午
 * Description:
 */
public class Code560 {
    public static void main(String[] args){
        int[] nums = {1,2,3};
        subarraySum(nums, 3);
    }

    public static int subarraySum(int[] nums, int k) {
//        int count = 0;
//        for (int i = 0; i < nums.length; i++) {
//            // 表示以 i 为起始位置的子数组的求和
//            int sum = nums[i];
//            if (sum == k) {
//                count++;
//            }
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum == k) {
//                    count++;
//                }
//            }
//        }

        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
}
