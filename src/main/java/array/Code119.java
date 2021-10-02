package array;

import java.util.ArrayList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/10/2 10:34 上午
 * Description: 118. 杨辉三角
 */
public class Code119 {
    public static void main(String[] args) {
        System.out.println(new Code119().getRow(5));
    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastLs = new ArrayList<>();
        List<Integer> currLs = new ArrayList<>();

        if (rowIndex == 0) {
            lastLs.add(1);
            return lastLs;
        }
        // 确定行
        for (int i = 1; i <= rowIndex; i++) {
            currLs = new ArrayList<>();
            // 确定列
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    currLs.add(1);
                    continue;
                }

                if (j == i) {
                    currLs.add(1);
                    continue;
                }

                // 取上一行的元素
                currLs.add(lastLs.get(j - 1) + lastLs.get(j));
            }
            lastLs = new ArrayList<>(currLs);
        }
        return currLs;
    }
}
