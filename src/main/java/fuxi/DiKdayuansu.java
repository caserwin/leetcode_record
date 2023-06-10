package fuxi;

import sort.Code912;

/**
 * User: caserwin
 * Date: 2023/6/10 1:11 下午
 * Description:
 */
public class DiKdayuansu {
    public static void main(String[] args) {
        int[] nums = {29, 10, 50, 34, 26, 25, 51, 30, 35, 50, 65, 21, 35, 14, 23, 26, 25, 37};
        System.out.println(new DiKdayuansu().findKthLargest(nums, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length - k];
    }


    public void sort(int[] nums) {
        quickSort(nums, 0, nums.length - 1);
    }


    public void quickSort(int[] nums, int left, int right) {
        if (left >= right) {
            return;
        }

        int i = left;
        int j = right;
        int base = nums[left];

        while (i < j) {
            if (nums[j] >= base) {
                j--;
                continue;
            }

            if (nums[i] <= base) {
                i++;
                continue;
            }
            swap(nums, i, j);
        }
        // 基准数归位
        swap(nums, i, left);
        quickSort(nums, left, i - 1);
        quickSort(nums, i + 1, right);
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    // 除了 while 中等号取不到，其余等号都可以取到。
}
