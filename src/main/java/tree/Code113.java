package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * User: caserwin
 * Date: 2021/8/8 2:18 下午
 * Description:
 *
 * @author yidxue
 */
public class Code113 {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        System.out.println(new Code113().pathSum(treeNode1, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 结果列表
        List<List<Integer>> res = new ArrayList<>();

        // 路径列表
        List<Integer> track = new ArrayList<>();

        // 回溯
        dfs(root, targetSum, track, res);

        return res;
    }

    public void dfs(TreeNode curNode, int targetSum, List<Integer> track, List<List<Integer>> res) {
        if (curNode == null) {
            return;
        }

        if (curNode.left == null && curNode.right == null && targetSum - curNode.val == 0) {
            track.add(curNode.val);
            res.add(new ArrayList<>(track));
            return;
        }

        track.add(curNode.val);
        if (curNode.left != null) {
            dfs(curNode.left, targetSum - curNode.val, track, res);
            track.remove(track.size() - 1);
        }

        if (curNode.right != null) {
            dfs(curNode.right, targetSum - curNode.val, track, res);
            track.remove(track.size() - 1);
        }
    }
}
