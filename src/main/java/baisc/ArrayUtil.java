package baisc;

import java.util.Arrays;

/**
 * @author yidxue
 * 方便调试
 */
public class ArrayUtil {
    public static void main(String[] args) {
        int[][] nums = new int[][]{{1, 2, 3}, {4, 5, 6}};
        printMatrix(nums);

        System.out.println("==========================");
        int[] nums1 = new int[]{1, 2, 3};
        System.out.println(Arrays.toString(nums1));
    }

    public static void printMatrix(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int element : aMatrix) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}
