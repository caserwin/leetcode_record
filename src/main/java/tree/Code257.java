package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code257 {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        System.out.println(new Code257().binaryTreePaths(treeNode1));
    }

    public List<String> binaryTreePaths(TreeNode root) {
        // 结果列表
        List<String> res = new ArrayList<>();

        // 路径列表
        List<Integer> track = new ArrayList<>();

        // 回溯
        dfs(root, track, res);

        return res;
    }

    public void dfs(TreeNode curNode, List<Integer> track, List<String> res) {
        if (curNode.left == null && curNode.right == null) {
            track.add(curNode.val);
            res.add(list2Str(track));
            return;
        }

        track.add(curNode.val);
        if (curNode.right != null) {
            dfs(curNode.right, track, res);
            track.remove(track.size() - 1);
        }

        if (curNode.left != null) {
            dfs(curNode.left, track, res);
            track.remove(track.size() - 1);
        }
    }

    private String list2Str(List<Integer> track) {
        StringBuilder sb = new StringBuilder();
        for (Integer integer : track) {
            sb.append(integer.toString()).append("->");
        }
        return sb.substring(0, sb.toString().length() - 2);
    }
}
