import java.util.HashMap;
import java.util.Map;

/**
 * User: caserwin
 * Date: 2021-07-25 11:30
 * Description:
 */
public class Code1 {

    public static void main(String[] args) {

        int[] nums = {3, 3};
        int target = 6;


        int[] res = twoSum(nums, target);
        for (int num : res) {
            System.out.println(num);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for (int num : nums) {
            map.put(index, num);
            index++;
        }

        int a = -1;
        int b = -1;
        for (Map.Entry<Integer, Integer> en : map.entrySet()) {
            if (map.containsValue(target - en.getValue())) {
                a = en.getKey();
                // 通过 value 找到 key
                for (Map.Entry<Integer, Integer> en1 : map.entrySet()) {
                    if (en1.getValue() == target - en.getValue() && en1.getKey().intValue() != en.getKey().intValue()) {
                        b = en1.getKey();
                    }
                }
            }
        }

        return new int[]{a, b};
    }
}
