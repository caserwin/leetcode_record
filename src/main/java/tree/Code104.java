package tree;

/**
 * @author yidxue
 */
public class Code104 {
    /**
     * 方法一
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
