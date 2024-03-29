package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yidxue
 * 求子集
 */
public class Code78 {


    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> ls = new Code78().subsets(nums);

        for (List<Integer> l : ls) {
            for (Integer integer : l) {
                System.out.print(integer + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 1. 整体评价：太经典了，必须还要重做多遍。
     * 2. 在一边循环一边遍历，本质上把遍历路径上所有的节点都加入了
     * 3. 和46,22,113 回溯问题不同的是：该解法没有显示的跳出 dfs 判断条件，而是 for 循环结束后自热跳出。
     * 4. 还有一点不同：该问题判断选择列表中哪些节点已经走过的方法比较巧妙。。直接通过 start + for 循环，避免了重复选择相同节点
     * 5. dfs参数：int[] nums, int start, List<Integer> list
     */
    public List<List<Integer>> subsets(int[] nums) {
        // 结果列表
        List<List<Integer>> res = new ArrayList<>();
        // 路径列表
        LinkedList<Integer> list = new LinkedList<>();
        // 回溯
        dfs(nums, 0, list, res);
        return res;
    }

    public void dfs(int[] nums, int index, LinkedList<Integer> list, List<List<Integer>> res) {
        res.add(new ArrayList<>(list));
        // 遍历后面的元素
        for (int i = index; i < nums.length; i++) {
            list.add(nums[index]);
            dfs(nums, i + 1, list, res);
            list.remove(list.size() - 1);
        }
    }
}