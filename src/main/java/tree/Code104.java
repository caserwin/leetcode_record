package tree;

/**
 * @author yidxue
 */
public class Code104 {
    /**
     * 记录最大深度
     */
    int res = 0;
    int depth = 0;

    /**
     * 方法一
     */
    public int maxDepth1(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if (root == null) {
            res = Math.max(res, depth);
            return;
        }
        // 前序遍历位置
        depth++;
        traverse(root.left);
        traverse(root.right);
        // 后序遍历位置
        depth--;
    }

    /**
     * 方法二
     */
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int rdeep = maxDepth(root.right);
        int ldeep = maxDepth(root.left);

        return Math.max(rdeep, ldeep) + 1;
    }
}
