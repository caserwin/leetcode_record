package shein20231026;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/11/1 07:45
 * Description:
 */
public class Code39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        //
        List<List<Integer>> resLs = new ArrayList<>();
        //
        LinkedList<Integer> track = new LinkedList<>();

        //
        dfs(resLs, track, candidates, target, 0);

        return resLs;
    }

    public void dfs(List<List<Integer>> resLs, LinkedList<Integer> track, int[] candidates, int target, int index) {
        if (target == sum(track) && !resLs.contains(track)){
            resLs.add(new ArrayList<>(track));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            if (target > sum(track)) {
                track.add(candidates[i]);
                dfs(resLs, track, candidates, target, i);
                track.removeLast();
            }
        }
    }

    public int sum(LinkedList<Integer> track){
        int sum = 0;
        for (Integer integer : track) {
            sum += integer;
        }
        return sum;
    }
}