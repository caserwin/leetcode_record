package tree;

/**
 * @author yidxue
 */
public class Code404 {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        System.out.println(new Code404().sumOfLeftLeaves1(treeNode1));
    }

    int res = 0;

    public int sumOfLeftLeaves(TreeNode root) {
        dfs(root.left, true);
        dfs(root.right, false);
        return res;
    }

    public void dfs(TreeNode root, boolean isLeft) {
        if (root == null) {
            return;
        }

        if (isLeft && root.left == null && root.right == null) {
            res += root.val;
        }

        if (root.left != null) {
            dfs(root.left, true);
        }

        if (root.right != null) {
            dfs(root.right, false);
        }
    }

    /**
     * 写法二：递推式 dfs
     */
    public int sumOfLeftLeaves1(TreeNode root) {
        int res = 0;
        res += dfs1(root.left, true);
        res += dfs1(root.right, false);
        return res;
    }

    public int dfs1(TreeNode root, boolean isLeft) {
        int res = 0;
        if (root == null) {
            return res;
        }

        if (isLeft && root.left == null && root.right == null) {
            res += root.val;
        }

        if (root.left != null) {
            res += dfs1(root.left, true);
        }

        if (root.right != null) {
            res += dfs1(root.right, false);
        }
        return res;
    }
}
