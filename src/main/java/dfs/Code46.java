package dfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code46 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> resList = new Code46().permute(nums);
        System.out.println(resList);
    }

    public List<List<Integer>> permute(int[] nums) {
        // 结果列表
        List<List<Integer>> resList = new ArrayList<>();
        // 已选路径
        LinkedList<Integer> linkedList = new LinkedList<>();
        getRes(nums, linkedList, resList);
        return resList;
    }

    private void getRes(int[] nums, LinkedList<Integer> linkedList, List<List<Integer>> resList) {
        // 已经到树的最底层了，记录路径，返回上一层
        if (linkedList.size() == nums.length) {
            resList.add(new LinkedList<>(linkedList));
            return;
        }
        for (int c : nums) {
            // 如果选项，不在已选路径中
            if (!linkedList.contains(c)) {
                linkedList.add(c);
                // 进入下一层树
                getRes(nums, linkedList, resList);
                // 回到上一层树，且已选路径中去掉该选项
                linkedList.removeLast();
            }
        }
    }

    /*
     * 感想：
     * 1. 这里有两个核心存储结构：
     *      - 1. 选择列表：这是个常量，不变的。其次通过contain 判断已经走过的路。
     *      - 2. 路径列表：如果一条路已经走到底了，则return 撤销选择。
     * 2. 这里最关键的一点是：如果 for 循环以后，没有数了。。则自动回到上一层，都没有 return。
     */
}
