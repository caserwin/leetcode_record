package tp;

/**
 * User: caserwin
 * Date: 2021/7/26 5:28 下午
 * Description:
 */
public class Code283_0 {

    /**
     * 和 code 26， 27 异曲同工，两个指针实现即可
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        while (left < nums.length) {
            // 与第一个非0元素交换位置
            if (nums[left] == 0) {
                int right = left + 1;
                boolean is = false;
                while (right < nums.length) {
                    if (nums[right] != 0) {
                        nums[left] = nums[right];
                        nums[right] = 0;
                        is = true;
                        break;
                    } else {
                        right++;
                    }
                }

                if (!is){
                    break;
                }
            }
            left++;
        }
    }
}
