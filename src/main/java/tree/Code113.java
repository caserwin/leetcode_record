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
        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(5);
        TreeNode treeNode10 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        treeNode6.left = treeNode9;
        treeNode6.right = treeNode10;

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
