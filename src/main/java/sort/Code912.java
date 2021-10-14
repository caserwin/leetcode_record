package sort;

/**
 * 数组排序，本质上要学会手撕快排
 * 目前记住：
 * 1. 基准位都是 left，对应基准数是 array[left]。
 */
public class Code912 {

    public static void main(String[] args) {
//        int[] nums = {29, 10, 50, 34, 26, 25, 51, 30, 35, 50, 65, 21, 35, 14, 23, 26, 25, 37};
        int[] nums = {25, 8, 26, 25, 26};
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
    public void sort1(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        // 以 array[left] 为基准数，以 left 为基准位
        int base = array[left];

        int i = left;
        int j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }
            swap(array, i, j);

            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }
            swap(array, i, j);
        }
        sort1(array, left, i - 1);
        sort1(array, i + 1, right);
    }

    /**
     * 快排随机基准数：有问题 {8, 25, 26, 25, 26} case 通不过
     * 好好想想为什么？该怎么改、、本质上是双指针技巧有 bug
     */
    public void sort(int[] array, int left, int right) {
        if (left > right) {
            return;
        }

        // 以 array[left] 为基准数，以 left 为基准位
        int index = (int) (Math.random() * (right - left)) + left;
        int base = array[index];
        System.out.println("index:" + index);

        int i = left;
        int j = right;
        while (i != j) {
            // 顺序很重要，先从右边开始往左找，直到找到比base值小的数
            while (array[j] >= base && i < j) {
                j--;
            }
            if (array[j] >= base) {
                swap(array, index, j);
                index = j;
            }
            // 再从左往右边找，直到找到比base值大的数
            while (array[i] <= base && i < j) {
                i++;
            }
            if (array[i] <= base) {
                swap(array, i, index);
                index = i;
            }
        }
        sort(array, left, index - 1);
        sort(array, index + 1, right);
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }
}
