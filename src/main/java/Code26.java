/**
 * User: caserwin
 * Date: 2021/7/26 10:41 上午
 * Description:
 */
public class Code26 {
    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {1};
        System.out.println(removeDuplicates(nums));
    }

    /**
     * 错误记录：
     * 1. if (!is) 中有 break ，表示right 指针走到头了。
     * 2. 删除重复元素是：nums[left + 1] = nums[right]; 实现的
     * 3. right 是全局变量，不是局部变量
     * 4. if (right < nums.length && nums[left] == nums[right])
     */
    public static int removeDuplicates(int[] nums) {
        int length = 0;
        int left = 0;
        int right = left + 1;
        while (left < nums.length) {
            if (right < nums.length && nums[left] == nums[right]) {
                // 找到第一个和 nums[left] 不相等的元素，放到left +1 位置上
                boolean is = false;
                while (right < nums.length) {
                    if (nums[left] != nums[right]) {
                        nums[left + 1] = nums[right];
                        is = true;
                        break;
                    } else {
                        right++;
                    }
                }
                if (!is) {
                    length = left + 1;
                    break;
                }
            } else {
                length = left + 1;
            }
            left++;
        }
        return length;
    }
}
