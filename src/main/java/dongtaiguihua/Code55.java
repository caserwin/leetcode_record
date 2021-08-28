package dongtaiguihua;

/**
 * User: caserwin
 * Date: 2021/8/16 8:42 上午
 * Description:
 */
public class Code55 {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1, 0, 4};
        System.out.println(new Code55().canJump(arr));
    }

    public boolean canJump(int[] nums) {
        int maxIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= maxIndex) {
                maxIndex = Math.max(maxIndex, nums[i] + i);
                if (maxIndex > nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
