package array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> resList = new ArrayList<>();
        int rowNums = matrix.length;
        int colNums = matrix[0].length;

        // 要遍历的总数
        int hasTraverseNum = rowNums * colNums;
        // 当前遍历的节点数量
        int currNum = 0;
        // 其起始位置
        int starti = 0;
        int startj = 0;

        // 如果还有节点没有遍历完
        while (currNum < hasTraverseNum) {
            // 1. 首先右走
            while (startj < colNums && matrix[starti][startj] != Integer.MAX_VALUE) {
                resList.add(matrix[starti][startj]);
                matrix[starti][startj] = Integer.MAX_VALUE;
                startj++;
                currNum++;
            }
            // 右走走完了，需要向下拐一步
            starti++;
            startj--;

            // 2. 再下走
            while (starti < rowNums && matrix[starti][startj] != Integer.MAX_VALUE) {
                resList.add(matrix[starti][startj]);
                matrix[starti][startj] = Integer.MAX_VALUE;
                starti++;
                currNum++;
            }
            // 下走走完了，需要向左拐一步
            starti--;
            startj--;

            // 3. 再左走
            while (startj >= 0 && matrix[starti][startj] != Integer.MAX_VALUE) {
                resList.add(matrix[starti][startj]);
                matrix[starti][startj] = Integer.MAX_VALUE;
                startj--;
                currNum++;
            }
            // 左走走完了，需要向上拐一步
            starti--;
            startj++;

            // 4. 最后上走
            while (starti >= 0 && matrix[starti][startj] != Integer.MAX_VALUE) {
                resList.add(matrix[starti][startj]);
                matrix[starti][startj] = Integer.MAX_VALUE;
                starti--;
                currNum++;
            }
            // 上走走完了，需要向右拐一步
            starti++;
            startj++;

        }
        return resList;
    }
}
