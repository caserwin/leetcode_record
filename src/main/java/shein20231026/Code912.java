package shein20231026;

/**
 * User: caserwin
 * Date: 2023/10/31 23:09
 * Description:
 */
public class Code912 {
    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length-1);
        return nums;
    }

    public void sort(int[] nums, int left, int right){
        if (left >= right){
            return;
        }
        int i = left;
        int j = right;
        int base = nums[left];
        while (i < j){
            if (nums[j] >= base){
                j--;
                continue;
            }

            if (nums[i] <= base){
                i++;
                continue;
            }
            swap(nums, i, j);
        }
        swap(nums, left, i);
        sort(nums, left, i-1);
        sort(nums,  i+1, right);
    }


    public void swap(int[] nums, int left, int right){
        int tmp = nums[left];
        nums[left] = nums[right];
        nums[right] = tmp;
    }
}
