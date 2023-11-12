package special.bs;

/**
 * @author yidxue
 * 在排序数组中查找元素的第一个和最后一个位置
 */
public class Code34 {
    public static void main(String[] args){
        int[] nums = {5,7,7,8,8,10};
        int target = 6;
        System.out.println(searchRange2(nums, target));
    }

    /**
     * O(n) 的复杂度
     */
    public int[] searchRange1(int[] nums, int target) {
        int first = -1;
        int last = -1;

        boolean is = true;
        for (int i = 0; i < nums.length; i++) {
            if (first != -1) {
                is = false;
            }

            if (nums[i] == target) {
                if (is) {
                    first = i;
                }
                last = i;
            }
        }
        return new int[]{first, last};
    }

    /**
     * 测试通过
     */
    public static int[] searchRange2(int[] nums, int target) {
        int leftIdx = search(nums, target, true);
        int rightIdx = search(nums, target, false);
        return new int[]{leftIdx, rightIdx};
    }

    public static int search(int[] nums, int target, boolean isLeft) {
        int left = 0;
        int right = nums.length - 1;
        int finalIndex = -1;

        while (left <= right){
            int mid = (left + right) / 2;
            if(target == nums[mid] ){
                finalIndex = mid;
                if (isLeft){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }
            if (target < nums[mid]){
                right = mid-1;
            }

            if (target > nums[mid]){
                left = mid + 1;
            }
        }
        return finalIndex;
    }
}
