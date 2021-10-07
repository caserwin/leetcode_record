package special.jump;

/**
 * User: caserwin
 * Date: 2021/8/16 8:42 上午
 * Description:
 * 1. 如果某一个作为 起跳点 的格子可以跳跃的距离是 3，那么表示后面 3 个格子都可以作为 起跳点
 * 2. 可以对每一个能作为 起跳点 的格子都尝试跳一次，把 能跳到最远的距离 不断更新
 * 3. 如果可以一直跳到最后，就成功了
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
