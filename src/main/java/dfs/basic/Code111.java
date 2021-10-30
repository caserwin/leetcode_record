package dfs.basic;

import tree.TreeNode;

/**
 * @author yidxue
 * 二叉树最小深度
 */
public class Code111 {

    /**
     * 方法1: 直接复制 leetcode 官方解答
     */
    public int minDepth1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        if (root.left == null && root.right == null) {
            return 1;
        }

        int minDepth = Integer.MAX_VALUE;
        if (root.left != null) {
            minDepth = Math.min(minDepth1(root.left), minDepth);
        }
        if (root.right != null) {
            minDepth = Math.min(minDepth1(root.right), minDepth);
        }

        return minDepth + 1;
    }


    /**
     * 方法2：
     * 1. 是我自己的写法，用了带全局变量的 dfs 方法。另外一种是不带全局变量的dfs方法，直接复制leetcode 官方解答了，参考方法1
     * 2. 对比 104 题，方法2 写法基本一致
     */
    int minDeep = Integer.MAX_VALUE;

    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        getMinDeepth(root, 1);
        return minDeep;
    }


    private void getMinDeepth(TreeNode node, int deep) {
        // 如果 node 是叶节点
        if (node.left == null && node.right == null) {
            minDeep = Math.min(minDeep, deep);
            return;
        }

        if (node.left != null) {
            getMinDeepth(node.left, deep + 1);
        }

        if (node.right != null) {
            getMinDeepth(node.right, deep + 1);
        }
    }
}