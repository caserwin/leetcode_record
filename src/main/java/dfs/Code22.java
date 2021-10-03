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

    public List<String> generateParenthesis(int n) {
        // 结果列表
        List<String> ans = new ArrayList<>();

        // 已选路径
        LinkedList<String> linkedList = new LinkedList<>();

        backtrack(ans, linkedList, 0, 0, n);
        return ans;
    }

    public void backtrack(List<String> ans, LinkedList<String> linkedList, int open, int close, int max) {
        if (linkedList.size() == max * 2) {
            ans.add(toString(linkedList));
            return;
        }

        if (open < max) {
            linkedList.add("(");
            backtrack(ans, linkedList, open + 1, close, max);
            linkedList.removeLast();
        }
        if (close < open) {
            linkedList.add(")");
            backtrack(ans, linkedList, open, close + 1, max);
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
