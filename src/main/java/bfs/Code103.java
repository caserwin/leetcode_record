package bfs;

import tree.TreeDataSource;
import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 *
 */
class Code103 {

    public static void main(String[] args){
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        new Code103().zigzagLevelOrder(treeNode1);
    }

    /**
     * 对比 102
     * 1. 102 中用了一个 queue 和 List，其中queue 用来辅助bfs, List 存储每层的节点。
     * 2. 103 中用了一个 queue 和 LinkedList，其中queue 用来辅助bfs, LinkedList 存储每层的节点。
     * 3. 主要用了 LinkedList 中 offerLast 和 offerFirst 两个方法。
     */
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        boolean isOrderLeft = true;

        while (!nodeQueue.isEmpty()) {
            Deque<Integer> levelList = new LinkedList<>();
            int size = nodeQueue.size();
            for (int i = 0; i < size; ++i) {
                TreeNode curNode = nodeQueue.poll();
                if (isOrderLeft) {
                    levelList.offerLast(curNode.val);
                } else {
                    levelList.offerFirst(curNode.val);
                }
                if (curNode.left != null) {
                    nodeQueue.offer(curNode.left);
                }
                if (curNode.right != null) {
                    nodeQueue.offer(curNode.right);
                }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }

        return ans;
    }
}
