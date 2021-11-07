package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 * 498. 对角线遍历数组
 */
public class Code498 {

    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        new Code498().findDiagonalOrder(mat);
    }

    public int[] findDiagonalOrder(int[][] mat) {
        int rowNums = mat.length;
        int colNums = mat[0].length;

        int all = rowNums + colNums - 2;

        // 把遍历结果存到 list 中能够， flag 标记到底是从左下到右上，还是从右上到左下
        boolean flag = true;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= all; i++) {
            fillElement(i, mat, flag, list, rowNums, colNums);
            flag = !flag;
        }

        // 把 list 中元素存放到数组中
        int[] res = new int[list.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = list.get(i);
        }

        return res;
    }

    private void fillElement(int target, int[][] mat, boolean flag, List<Integer> list, int rowNums, int colNums) {
        if (flag) {
            // 表示从左下到右上，本质上行是递减的，列是递增的
            int tmpRow = target;
            while (tmpRow >= 0 && target - tmpRow >= 0) {
                // TODO 这里要加判断
                if (tmpRow < rowNums && target - tmpRow < colNums) {
                    list.add(mat[tmpRow][target - tmpRow]);
                }
                tmpRow--;
            }
        } else {
            // 表示从右上到左下，本质上行是递增的
            int tmpCol = target;
            while (tmpCol >= 0 && target - tmpCol >= 0) {
                // TODO 这里要加判断，不然边界问题会报错
                if (target - tmpCol < rowNums && tmpCol < colNums) {
                    list.add(mat[target - tmpCol][tmpCol]);
                }
                tmpCol--;
            }
        }
    }
}
