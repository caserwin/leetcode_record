/**
 * User: caserwin
 * Date: 2021-07-25 16:34
 * Description:
 */
public class Code4 {
    public static void main(String[] args) {

        int[] nums1 = {};
        int[] nums2 = {2, 3};

        System.out.println(findMedianSortedArrays(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] mergeNum = new int[nums1.length + nums2.length];

        int index1 = 0;
        int index2 = 0;

        for (int i = 0; i < mergeNum.length; i++) {

            if (index1 < nums1.length && index2 < nums2.length && nums1[index1] <= nums2[index2]) {
                mergeNum[i] = nums1[index1];
                index1++;
                continue;
            }

            if (index1 < nums1.length && index2 < nums2.length && nums1[index1] > nums2[index2]) {
                mergeNum[i] = nums2[index2];
                index2++;
                continue;
            }

            if (index1 < nums1.length) {
                mergeNum[i] = nums1[index1];
                index1++;
                continue;
            }

            if (index2 < nums2.length) {
                mergeNum[i] = nums2[index2];
                index2++;
            }
        }

        if (mergeNum.length % 2 == 0) {
            return (float) (mergeNum[mergeNum.length / 2] + mergeNum[mergeNum.length / 2 - 1]) / 2;
        } else {
            return (float) mergeNum[mergeNum.length / 2];
        }
    }
}
