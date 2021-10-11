package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author casyd_xue
 * 括号生成
 */
public class Code22 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Code22().generateParenthesis(n));
    }

    /**
     * 和 46 题类型一致，本质上是全局式变量式的 dfs，但是这个全局变量通过 dfs 方法参数维护，而不是方法外的全局变量维护。
     */
    public List<String> generateParenthesis(int n) {
        // 结果列表
        List<String> ans = new ArrayList<>();

        // 已选路径
        LinkedList<String> linkedList = new LinkedList<>();

        dfs(ans, linkedList, 0, 0, n);
        return ans;
    }

    public void dfs(List<String> ans, LinkedList<String> linkedList, int open, int close, int max) {
        if (linkedList.size() == max * 2) {
            ans.add(toString(linkedList));
            return;
        }

        if (open < max) {
            linkedList.add("(");
            dfs(ans, linkedList, open + 1, close, max);
            linkedList.removeLast();
        }
        if (close < open) {
            linkedList.add(")");
            dfs(ans, linkedList, open, close + 1, max);
            linkedList.removeLast();
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
