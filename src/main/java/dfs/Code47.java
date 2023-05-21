package dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yidxue
 * 回溯
 */
public class Code47 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> resList = new Code47().permute(nums);
        System.out.println(resList);
    }

    boolean[] vis;
    public List<List<Integer>> permute(int[] nums) {
        // 结果列表
        List<List<Integer>> ans = new ArrayList<>();
        // 已选路径
        LinkedList<Integer> linkedList = new LinkedList<>();
        // 回溯
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(nums, linkedList, ans);
        return ans;
    }


    private void dfs(int[] nums, LinkedList<Integer> linkedList, List<List<Integer>> resList) {
        // 已经到树的最底层了，记录路径，返回上一层
        if (linkedList.size() == nums.length && !resList.contains(linkedList)) {
            resList.add(new LinkedList<>(linkedList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (vis[i]) {
                continue;
            }
            // 如果选项，不在已选路径中
            linkedList.add(nums[i]);
            vis[i] = true;
            // 进入下一层树
            dfs(nums, linkedList, resList);
            // 回到上一层树，且已选路径中去掉该选项
            vis[i] = false;
            linkedList.removeLast();
        }
    }
}
