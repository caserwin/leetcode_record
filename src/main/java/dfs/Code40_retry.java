package dfs;

import java.lang.reflect.Array;
import java.util.*;

/**
 * 组合问题 2
 * candidates = [10,1,2,7,6,1,5], target = 8
 * [[1,1,6], [1,2,5], [1,7], [2,6] ]
 */
public class Code40_retry {
    public static void main(String[] args) {
        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
//        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        int target = 25;
        System.out.println(new Code40_retry().combinationSum2(candidates, target));
    }

    /**
     * TODO 直接复制 39 题代码，做了微改。功能是可以运行的，可惜超时了。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 结果列表
        List<List<Integer>> ans = new ArrayList<>();
        // 路径列表
        LinkedList<Integer> track = new LinkedList<>();
        // 开始回溯
        Arrays.sort(candidates);
        dfs(candidates, target, 0, track, ans);

        return ans;
    }

    private void dfs(int[] candidates, int target, int index, LinkedList<Integer> track, List<List<Integer>> ans) {
        if (sum(track) == target && !ans.contains(track)) {
            ans.add(new ArrayList<>(track));
            return;
        }

        if (track.size() == candidates.length) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            track.add(candidates[i]);
            dfs(candidates, target, i + 1, track, ans);
            track.removeLast();
        }
    }

    private int sum(LinkedList<Integer> linkedList) {
        int sum = 0;
        for (Integer integer : linkedList) {
            sum += integer;
        }
        return sum;
    }
}