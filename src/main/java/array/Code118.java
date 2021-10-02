package array;

import java.util.ArrayList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/10/2 10:34 上午
 * Description: 118. 杨辉三角
 */
public class Code118 {
    public static void main(String[] args) {
        System.out.println(new Code118().generate(5));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> tmplist = new ArrayList<>();

        tmplist.add(1);
        res.add(new ArrayList<>(tmplist));
        tmplist = new ArrayList<>();

        // 表示第 i 行，从第1行开始
        for (int i = 1; i < numRows; i++) {
            // 表示第 j 个元素
            for (int j = 0; j <= i; j++) {
                if (j == 0) {
                    tmplist.add(1);
                    continue;
                }

                if (j == i) {
                    tmplist.add(1);
                    continue;
                }
                // 取上一行的元素
                tmplist.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            res.add(new ArrayList<>(tmplist));
            tmplist = new ArrayList<>();
        }

        return res;
    }
}
