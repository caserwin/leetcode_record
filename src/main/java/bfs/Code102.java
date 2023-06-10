package bfs;

import tree.TreeDataSource;
import tree.TreeNode;

import java.util.*;

/**
 * @author yidxue
 * 记录：code102，二叉树层序遍历，即广度优先遍历
 * 1. 每一层遍历开始时，先用一个 ArrayList 记录这一层的遍历结果。
 * 2. 每一层遍历开始时，都先要知道这一层有多少个元素，记为 currLevelNum。
 * 3. 因为 Queue 有先进先出特点，所以当 currLevelNum 确定时，只要通过 for 循环不断 poll，就能拿到当前层所有节点元素。
 * 4. 还有就是要记得 Java 中 Queue 的实例化方式。
 */
public class Code102 {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        List<List<Integer>> res = new Code102().levelOrder(treeNode1);
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<>();
        if (root == null) {
            return ret;
        }

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
