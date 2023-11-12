package shein20231026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/11/1 06:54
 * Description:
 */
public class Code77 {
    public List<List<Integer>> combine(int n, int k) {
        // 结果列表
        List<List<Integer>> ans = new ArrayList<>();

        // 已选路径
        LinkedList<Integer> track = new LinkedList<>();

        // 回溯
        dfs(n, k, track, ans, 1);

        return ans;
    }

    public void dfs(int n, int k, LinkedList<Integer> track, List<List<Integer>> res, int start) {
        if (track.size() == k){
            res.add(new ArrayList<>(track));
            return;
        }

        for (int i = start; i <= n; i++) {
            track.add(i);
            dfs(n ,k, track, res, i+1);
            track.removeLast();
        }
    }
}
