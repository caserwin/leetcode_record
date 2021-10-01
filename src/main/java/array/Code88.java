package array;

/**
 * User: caserwin
 * Date: 2021/8/8 1:46 下午
 * Description: 合并两个有序数组
 * 解题思路：双指针
 */
public class Code88 {
    public static void main(String[] args) {
//        int[] nums1 = {1, 2, 3, 0, 0, 0};
//        int[] nums2 = {2, 5, 6};

        int[] nums1 = {1};
        int[] nums2 = {};

        new Code88().merge(nums1, 1, nums2, 0);

        for (int num1 : nums1) {
            System.out.println(num1);
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] sortArr = new int[m + n];
        int i = 0;
        int j = 0;

        while (i < m || j < n) {
            if (i == m) {
                sortArr[i + j] = nums2[j];
                j++;
            } else if (j == n) {
                sortArr[i + j] = nums1[i];
                i++;
            } else if (nums1[i] <= nums2[j]) {
                sortArr[i + j] = nums1[i];
                i++;
            } else {
                sortArr[i + j] = nums2[j];
                j++;
            }
        }

        System.arraycopy(sortArr, 0, nums1, 0, sortArr.length);
    }
}
