package tree;

/**
 * @author yidxue
 */
public class Code110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = getDeep(root.left, 0) - getDeep(root.right, 0);
        return (Math.abs(diff) == 1 || Math.abs(diff) == 0) && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getDeep(TreeNode root, int deep) {
        if (root == null) {
            return deep;
        }
        if (root.right == null && root.left == null) {
            return deep + 1;
        }
        int rdeep = root.right != null ? getDeep(root.right, deep + 1) : deep;
        int ldeep = root.left != null ? getDeep(root.left, deep + 1) : deep;

        return Math.max(rdeep, ldeep);
    }
}
