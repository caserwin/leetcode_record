package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author casyd_xue
 * 括号生成
 */
public class Code22_retry {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(new Code22_retry().generateParenthesis(n));
    }

    /**
     * 和 46 题类型一致，本质上是全局式变量式的 dfs，但是这个全局变量通过 dfs 方法参数维护，而不是方法外的全局变量维护。
     */
    public List<String> generateParenthesis(int n) {
        // 结果列表
        List<String> res = new ArrayList<>();

        // 已选路径
        LinkedList<String> track = new LinkedList<>();

        // dfs
        dfs(res, track, n, 0, 0);
        return res;
    }

    public void dfs(List<String> res, LinkedList<String> track, int n, int left, int right) {
        if (track.size() == n * 2) {
            res.add(toString(track));
            return;
        }

        for (int i = left; i < n; i++) {
            track.add("(");
            dfs(res, track, n, i + 1, right);
            track.removeLast();
        }

        for (int i = right; i < left; i++) {
            track.add(")");
            dfs(res, track, n, left, i + 1);
            track.removeLast();
        }
    }

    private String toString(LinkedList<String> linkedList) {
        StringBuilder res = new StringBuilder();
        for (String str : linkedList) {
            res.append(str);
        }
        return res.toString();
    }
}
