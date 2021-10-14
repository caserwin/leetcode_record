package tree;

/**
 * @author yidxue
 * 二叉树的直径
 */
public class Code543 {

    int ans;

    /**
     * 说明：
     * 1. 这是leetcode 官方答案，做这题之前先把 104 给做了。
     * 2. 该题核心思路：树的直径是某个节点左右子树的最大深度之和再加1。
     * 3. 要遍历所有节点，计算和记录每个节点的 left tree deepth + right tree deepth + 1，记为 tmpD。
     * 4. 优化点：一开始想是用一个 HashMap 来存每个节点的 tmpD。但是想到后面还要遍历 HashMap 取出最大的 tmpD 作为 ans。还不如直接存一个 ans，记录最大值。
     */
    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int l = depth(node.left);
        int r = depth(node.right);
        ans = Math.max(ans, l + r + 1);
        return Math.max(l, r) + 1;
    }

    public int diameterOfBinaryTree1(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rdeep = diameterOfBinaryTree1(root.right);
        int ldeep = diameterOfBinaryTree1(root.left);

        ans = Math.max(ans, rdeep + ldeep + 1);

        return Math.max(rdeep, ldeep) + 1;
    }
}
