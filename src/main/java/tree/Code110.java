package tree;

/**
 * @author yidxue
 */
public class Code110 {

    public static void main(String[] args) {
        TreeNode treeNode = TreeDataSource.getTreeNode1();
        System.out.println(new Code110().isBalanced(treeNode));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = getDeep(root.left, 0) - getDeep(root.right, 0);
        return (Math.abs(diff) == 1 || Math.abs(diff) == 0) && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 全局变量式的 dfs，其中全局变量通过方法参数传递来维护。
     */
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


    public boolean isBalanced1(TreeNode root) {
        if (root == null) {
            return true;
        }
        int diff = getDeep(root.left) - getDeep(root.right);
        return (Math.abs(diff) == 1 || Math.abs(diff) == 0) && isBalanced(root.left) && isBalanced(root.right);
    }

    /**
     * 递推式的dfs，计算每个节点的最大深度
     */
    private int getDeep(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 1;
        }
        int rdeep = getDeep(root.right) + 1;
        int ldeep = getDeep(root.left) + 1;

        return Math.max(rdeep, ldeep);
    }
}