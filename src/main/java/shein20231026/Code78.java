package shein20231026;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2023/10/31 23:56
 * Description:
 */
public class Code78 {
    public List<List<Integer>> subsets(int[] nums) {
        //
        List<List<Integer>> resLs = new ArrayList<>();
        //
        LinkedList<Integer> track = new LinkedList<>();

        //
        dfs(resLs, track, nums, 0);

        return resLs;
    }

    public void dfs(List<List<Integer>> resLs,  LinkedList<Integer> track, int[] nums, int index){
        if (!resLs.contains(track)){
            resLs.add(new ArrayList<>(track));
        }

        for (int i = index; i < nums.length; i++) {
            track.add(nums[i]);
            dfs(resLs, track, nums, index + 1);
            track.removeLast();
        }
    }
}
