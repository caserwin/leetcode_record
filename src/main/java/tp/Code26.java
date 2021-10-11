package tp;

/**
 * @author yidxue
 * 原地删除重复元素，和283 非常像，唯一不同的是 283 需要交换，但是这里直接用fast指针的值替换 slow 指针的值即可。
 */
public class Code26 {

    public static void main(String[] args) {
//        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] nums = {1, 1, 2};
        System.out.println(new Code26().removeDuplicates1(nums));
    }

    /**
     * 双指正-快慢指针技巧
     * 1. fast和slow 从1 开始。
     * 2. fast 不断和前一位作对比：
     *      如果不满足[题目]条件，就把 slow 放到这里，fast ++;
     *      如果满足[题目]条件，则 fast 和 slow 交换。fast++, slow++
     *      这样slow 位置之前的元素，都是符合题目条件的
     */
    public int removeDuplicates1(int[] nums) {
        int fast = 1;
        int slow = 1;
        while (fast < nums.length) {
            if (nums[fast] != nums[fast - 1]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }


    /**
     * 错误记录：
     * 1. if (!is) 中有 break ，表示right 指针走到头了。
     * 2. 删除重复元素是：nums[left + 1] = nums[right]; 实现的
     * 3. right 是全局变量，不是局部变量
     * 4. if (right < nums.length && nums[left] == nums[right])
     */
    public int removeDuplicates(int[] nums) {
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
