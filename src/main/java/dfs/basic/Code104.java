package dfs.basic;

import tree.TreeNode;

/**
 * @author yidxue
 * 二叉树最大深度
 */
public class Code104 {

    /**
     * 方法1
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rdeep = maxDepth(root.right);
        int ldeep = maxDepth(root.left);

        return Math.max(rdeep, ldeep) + 1;
    }


    /**
     * 方法2：对比 111 题
     */
    int maxDeep = Integer.MIN_VALUE;
    public int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getMaxDeepth(root, 1);
        return maxDeep;
    }

    private void getMaxDeepth(TreeNode node, int deep) {
        // 如果 node 是叶节点
        if (node.left == null && node.right == null) {
            maxDeep = Math.max(maxDeep, deep);
            return;
        }

        if (node.left != null) {
            getMaxDeepth(node.left, deep + 1);
        }

        if (node.right != null) {
            getMaxDeepth(node.right, deep + 1);
        }
    }
}
