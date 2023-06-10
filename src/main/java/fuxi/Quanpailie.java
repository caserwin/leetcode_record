package fuxi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/6/10 11:43 上午
 * Description:
 */
public class Quanpailie {
    public static void main(String[] args) {
        String[] arr = {"1", "2", "3"};
        List<LinkedList<String>> list = new Quanpailie().getRes(arr);
        for (LinkedList<String> ss : list) {
            System.out.println(ss);
        }
    }

    public List<LinkedList<String>> getRes(String[] arr) {
        // 路径列表
        LinkedList<String> track = new LinkedList<>();

        // 结果列表
        List<LinkedList<String>> res = new ArrayList<>();

        //
        dfs(arr, track, res);

        return res;
    }

    public void dfs(String[] arr, LinkedList<String> track, List<LinkedList<String>> res) {
        if (track.size() == arr.length) {
            res.add(new LinkedList<>(track));
            return;
        }

        for (String s : arr) {
            if (!track.contains(s)) {
                track.add(s);
                dfs(arr, track, res);
                track.removeLast();
            }
        }
    }
}
