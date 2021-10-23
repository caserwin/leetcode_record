package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 组合问题
 * candidates = [2,3,6,7], target = 7
 * [[7],[2,2,3]]
 */
public class Code39 {
    public static void main(String[] args) {
        int[] candidates = {2, 3, 6, 7};
        int target = 7;
        System.out.println(new Code39().combinationSum(candidates, target));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // 结果列表
        List<List<Integer>> ans = new ArrayList<>();
        // 路径列表
        LinkedList<Integer> track = new LinkedList<>();
        // 开始回溯
        dfs(candidates, target, 0, track, ans);

        return ans;
    }

    /**
     * 1. 和子集问题很像，但这题不同的是：一个元素可以无限制取。但是子集问题不行，所以必须通过 dfs + for 循环中 index 标记位跳过已取过的元素
     * 2. 当时写过没有 index 参数的实现
     * 3. 类似题目：93 复原IP，78 子集问题非常像
     */
    private void dfs(int[] candidates, int target, int index, LinkedList<Integer> track, List<List<Integer>> ans) {
        if (sum(track) == target) {
            ans.add(new LinkedList<>(track));
            return;
        }

        if (sum(track) > target) {
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            track.add(candidates[i]);
            // TODO 注意这里 index 参数每次传入的是 i
            dfs(candidates, target, i, track, ans);
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