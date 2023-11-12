package shein20231026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/11/1 08:32
 * Description:
 */
public class Code22 {
    public List<String> generateParenthesis(int n) {
        // 结果列表
        List<String> ans = new ArrayList<>();

        // 已选路径
        LinkedList<String> linkedList = new LinkedList<>();

        dfs(ans, linkedList, 0, 0, n);
        return ans;
    }


    public void dfs(List<String> ans, LinkedList<String> track, int open, int close, int max) {
        if (track.size() == max * 2) {
            ans.add(toString(track));
            return;
        }

        for (int i = open; i < max; i++) {
            track.add("(");
            dfs(ans, track, open, close, max);
            track.removeLast();
        }

        for (int i = close; i < open; i++) {
            track.add(")");
            dfs(ans, track, open, close, max);
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
