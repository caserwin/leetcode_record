package shein20231026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/10/27 00:05
 * Description:
 */
public class Code46 {

    public List<List<Integer>> permute(int[] nums) {
        // 路径
        LinkedList<Integer> track = new LinkedList<>();
        // 记录结果
        List<List<Integer>> result = new LinkedList<>();

        dfs(nums, track, result);
        return result;
    }

    public void dfs(int[] nums, LinkedList<Integer> track, List<List<Integer>> result){
        if (track.size() == nums.length){
            result.add(new ArrayList<>(track));
            return;
        }

        for (int num : nums) {
            if (!track.contains(num)) {
                track.add(num);
                dfs(nums, track, result);
                track.removeLast();
            }
        }
    }
}
