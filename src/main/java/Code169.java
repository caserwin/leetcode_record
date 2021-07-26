import java.util.Arrays;

/**
 * User: caserwin
 * Date: 2021/7/26 5:27 下午
 * Description:
 */
public class Code169 {
    public static void main(String[] args){

    }
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
