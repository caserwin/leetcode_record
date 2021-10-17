package baisc;

/**
 * @author yidxue
 */
public class ArrayUtil {
    public static void printMatrix(int[][] matrix) {
        for (int[] aMatrix : matrix) {
            for (int element : aMatrix) {
                System.out.print(element + "\t");
            }
            System.out.println();
        }
    }
}
