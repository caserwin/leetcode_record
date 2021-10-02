package tp;

import java.util.LinkedList;

/**
 * @author casyd_xue
 * 给定一个由若干 0 和 1 组成的数组 A，我们最多可以将 K 个值从 0 变成 1 。
 * 返回仅包含 1 的最长（连续）子数组的长度。
 * 示例 1：
 * 输入：A = [1,1,1,0,0,0,1,1,1,1,0], K = 2
 * 输出：6
 * 解释：
 * [1,1,1,0,0,1,1,1,1,1,1]
 * 粗体数字从 0 翻转到 1，最长的子数组长度为 6。
 */
public class Code1004 {
    public static void main(String[] args) {
//        int[] array = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0};
//        int k = 2;
        int[] array = {0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1};
        int k = 3;
        System.out.println(new Code1004().longestOnes(array, k));
    }

    public int longestOnes(int[] A, int K) {
        int left = 0;
        int right = 0;
        int tmpK = K;

        // 用于记录 0 的位置
        LinkedList<Integer> linkedList = new LinkedList<>();

        // 记录最长的长度
        int maxLen = Integer.MIN_VALUE;
        while (right < A.length) {
            // 先把判断操作做了
            if (A[right] == 1) {
                maxLen = Math.max(maxLen, right - left + 1);
                right++;
            } else {
                // 记录 0 元素的位置
                linkedList.add(right);

                if (tmpK > 0) {
                    tmpK--;
                    maxLen = Math.max(maxLen, right - left + 1);
                    right++;
                }
            }

            //已经不满足条件了，左边 left 必须左移，直到满足条件
            if (tmpK == 0) {
                // 这样表示跳过了1个0
                left = linkedList.removeFirst() + 1;
                // 因为跳过了一个 0，tmpK 就可以加1
                tmpK++;
            }
        }
        return maxLen;
    }

//    public int longestOnes1(int[] nums, int k) {
//        int n = nums.length;
//        int left = 0, lsum = 0, rsum = 0;
//        int ans = 0;
//        for (int right = 0; right < n; ++right) {
//            rsum += 1 - nums[right];
//            while (lsum < rsum - k) {
//                lsum += 1 - nums[left];
//                ++left;
//            }
//            ans = Math.max(ans, right - left + 1);
//        }
//        return ans;
//    }
}
