package dfs;

import tree.TreeDataSource;
import tree.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yidxue
 * 二叉树目标和
 */
public class Code113 {
    public static void main(String[] args) {
        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        System.out.println(new Code113().pathSum(treeNode1, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        // 结果列表
        List<List<Integer>> ans = new ArrayList<>();

        // 已选路径
        LinkedList<Integer> track = new LinkedList<>();

        // 回溯
        dfs(root, targetSum, track, ans);

        return ans;
    }

    public void dfs(TreeNode curNode, int targetSum, LinkedList<Integer> track, List<List<Integer>> res) {
        if (curNode == null) {
            return;
        }

        track.add(curNode.val);
        if (curNode.left == null && curNode.right == null && targetSum - curNode.val == 0) {
            res.add(new ArrayList<>(track));
            return;
        }

        if (curNode.left != null) {
            dfs(curNode.left, targetSum - curNode.val, track, res);
            track.removeLast();
        }

        if (curNode.right != null) {
            dfs(curNode.right, targetSum - curNode.val, track, res);
            track.removeLast();
        }
    }
}
