package dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题 2
 * candidates = [10,1,2,7,6,1,5], target = 8
 * [[1,1,6], [1,2,5], [1,7], [2,6] ]
 */
public class Code40 {
    public static void main(String[] args) {
//        int[] candidates = {10, 1, 2, 7, 6, 1, 5};
//        int target = 8;
        int[] candidates = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        int target = 25;
        System.out.println(new Code40().combinationSum2(candidates, target));
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
        dfs(candidates, target, 0, track, ans);

        return ans;
    }

    private void dfs(int[] candidates, int target, int index, LinkedList<Integer> track, List<List<Integer>> ans) {
        if (sum(track) == target) {
            LinkedList<Integer> linkedList = new LinkedList<>(track);
            linkedList.sort(Comparator.naturalOrder());
            if (!ans.contains(linkedList)) {
                ans.add(linkedList);
            }
            return;
        }

        if (sum(track) > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            track.add(candidates[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
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



    public List<List<Integer>> combinationSum2V2(int[] candidates, int target) {
        // 结果列表
        List<List<Integer>> ans = new ArrayList<>();
        // 路径列表
        LinkedList<Integer> track = new LinkedList<>();
        // 开始回溯
        dfs2(candidates, target, 0, track, ans);

        return ans;
    }

    private void dfs2(int[] candidates, int target, int index, LinkedList<Integer> track, List<List<Integer>> ans) {
        if (sum(track) == target) {
            LinkedList<Integer> linkedList = new LinkedList<>(track);
            linkedList.sort(Comparator.naturalOrder());
            if (!ans.contains(linkedList)) {
                ans.add(linkedList);
            }
            return;
        }

        if (sum(track) > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            track.add(candidates[i]);
            // 因为元素不可以重复使用，这里递归传递下去的是 i + 1 而不是 i
            dfs2(candidates, target, i + 1, track, ans);
            track.removeLast();
        }
    }
}