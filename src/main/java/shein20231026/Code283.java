package shein20231026;

/**
 * User: caserwin
 * Date: 2023/11/2 08:48
 * Description:
 */
public class Code283 {
    public static void main(String[] args){
        int[] nums = {1,2,0,3,12};
        moveZeroes(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        while (right < len){
            if (nums[right] == 0){
                right ++;
                continue;
            }

            if (nums[left] != 0){
                left ++;
                continue;
            }

            if (right > left){
                swap(nums, left, right);
            }else {
                right++;
            }
        }
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
