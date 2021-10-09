package sort;

/**
 * 数组排序，本质上要学会手撕快排
 * 目前记住：
 *      1. 基准位都是 left，对应基准数是 array[left]。
 *
 */
public class Code912 {

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
//            int[] nums = {5, 2, 3, 1};
            int[] nums = {5, 1, 1, 2, 0, 0};
            new Code912().sortArray(nums);
            for (int num : nums) {
                System.out.print(num);
            }
            System.out.println();
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

//        int index = (int) (Math.random() * (right - left)) + left;
//        int basic = nums[index];

        // 以 array[left] 为基准数，以 left 为基准位
        int base = array[left];

        int i = left;
        int j = right;
        while (i < j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }
            // 上面的循环结束表示找到了位置或者(i>=j)了，交换两个数在数组中的位置
            swap(array, i, j);
        }
        // TODO 基准数归位，一开始基准书位置是left，要把left 和最后一次交换的位置，进行交换。
        swap(array, i, left);

        sort(array, left, i - 1);
        sort(array, j + 1, right);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
