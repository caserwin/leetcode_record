package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 */
public class Code56 {
    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {8, 10}, {2, 6}, {15, 18}};
        int[][] res = new Code56().merge(intervals);
        for (int[] re : res) {
            System.out.println(Arrays.toString(re));
        }
    }

    public int[][] merge(int[][] intervals) {
        // 排序
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        // 存到结果
        List<int[]> merged = new ArrayList<>();

        // 遍历
        int gTmpL = intervals[0][0];
        int gTmpR = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            int tmpL = intervals[i][0];
            int tmpR = intervals[i][1];

            // 说明有交集
            if (tmpL >= gTmpL && tmpL <= gTmpR) {
                // 更新 gTmpR
                gTmpR = Math.max(gTmpR, tmpR);
            } else {
                // 说明没有交集
                merged.add(new int[]{gTmpL, gTmpR});
                // 更新 gTmpL， gTmpR
                gTmpL = tmpL;
                gTmpR = tmpR;
            }
        }
        // 更新最后一个元素
        merged.add(new int[]{gTmpL, gTmpR});


        // 把 merged 更新到 int[][]
        int[][] res = new int[merged.size()][2];
        int index = 0;
        for (int[] i : merged) {
            res[index] = i;
            index++;
        }

        return res;
    }
}
