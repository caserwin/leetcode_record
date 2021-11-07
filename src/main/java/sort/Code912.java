package sort;

/**
 * 数组排序，本质上要学会手撕快排
 * 1. 基准数以 left 为主
 * 2. 若基准数选择 left，则要从right 开始遍历。
 * 3. 记住基准数要归位。
 */
public class Code912 {

    public static void main(String[] args) {
        int[] nums = {29, 10, 50, 34, 26, 25, 51, 30, 35, 50, 65, 21, 35, 14, 23, 26, 25, 37};
//        int[] nums = {25, 8, 26, 25, 26};
        new Code912().sortArray(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

    public int[] sortArray(int[] nums) {
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    /**
     * 快排核心算法，递归实现
     */
    public void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        // 以 array[left] 为基准数，以 left 为基准位
        int base = array[left];

        int i = left;
        int j = right;
        while (i < j) {
            // 右边的数大于base，则跳过
            if (array[j] >= base) {
                j--;
                continue;
            }

            // 左边的小于base，则跳过
            if (array[i] <= base) {
                i++;
                continue;
            }
            swap(array, i, j);
        }

        // 基准数归位
        swap(array, left, i);

        sort(array, left, i - 1);
        sort(array, i + 1, right);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
