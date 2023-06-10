package fuxi;

import tree.TreeDataSource;
import tree.TreeNode;

import java.util.*;

/**
 * User: caserwin
 * Date: 2023/6/10 2:17 下午
 * Description:
 */
public class ErChaShuCXBL {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        new ErChaShuCXBL().levelOrder(treeNode1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new PriorityQueue<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }

        return ret;
    }
}
