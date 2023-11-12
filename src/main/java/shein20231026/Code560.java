package shein20231026;

import java.util.HashMap;

/**
 * User: caserwin
 * Date: 2023/11/12 09:54
 * Description:
 */
public class Code560 {

    public static void main(String[] args){
        int[] nums = {1} ;
        int k = 0;
        System.out.println(subarraySum1(nums, k));
//        System.out.println(subarraySum2(nums, k));
    }
    public static int subarraySum1(int[] nums, int k) {
        // key 为前缀和，v为出现次数
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);

        int count = 0;
        int pre = 0;
        for (int num : nums) {
            pre += num;
            if (map.containsKey(pre - k)) {
                count += map.get(pre - k);
            }

            if (!map.containsKey(pre)) {
                map.put(pre, 1);
            } else {
                map.put(pre, map.get(pre) + 1);
            }
        }
        return count;
    }
//
//    public static int subarraySum2(int[] nums, int k) {
//        int count = 0, pre = 0;
//        HashMap < Integer, Integer > mp = new HashMap < > ();
//        mp.put(0, 1);
//        for (int num : nums) {
//            pre += num;
//            if (mp.containsKey(pre - k)) {
//                count += mp.get(pre - k);
//            }
//            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
//        }
//        return count;
//    }
}