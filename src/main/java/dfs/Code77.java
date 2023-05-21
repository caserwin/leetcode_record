package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/5/20 3:25 下午
 * Description:
 */
public class Code77 {
    public static void main(String[] args){

        List<List<Integer>> ls = new Code77().combine(4,2);

        for (List<Integer> l : ls) {
            for (Integer integer : l) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        // 结果列表
        List<List<Integer>> res = new ArrayList<>();

        // 路径列表
        LinkedList<Integer> tack = new LinkedList<>();

        dfs(n, k, 1,tack, res);
        return res;
    }

    public void dfs(int n, int k, int index, LinkedList<Integer> track, List<List<Integer>> res) {
        if (track.size() == k){
            res.add(new LinkedList<>(track));
            return;
        }

        for (int i = index; i <= n; i++) {
            track.add(i);
            dfs(n, k, i+1, track, res);
            track.removeLast();
        }
    }
}
