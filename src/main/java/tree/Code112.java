package tree;

/**
 * User: caserwin
 * Date: 2021/8/8 2:18 下午
 * Description:
 *
 * @author yidxue
 */
public class Code112 {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        System.out.println(new Code112().hasPathSum(treeNode1, 22));
    }

    /**
     * 用递归方式，递归跳出条件有二：1. 该节点是叶节点。 2. targetSum == 0。
     * 否则一直做递减递归。
     * <p>
     * 做错的地方：if (root.left == null && root.right == null && targetSum == 0)
     * 改成：if (root.left == null && root.right == null && root.val - targetSum == 0)
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val - targetSum == 0) {
            return true;
        } else if (root.left == null && root.right != null) {
            return hasPathSum(root.right, targetSum - root.val);
        } else if (root.left != null && root.right == null) {
            return hasPathSum(root.left, targetSum - root.val);
        } else if (root.left != null && root.right != null) {
            return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
        } else {
            return false;
        }
    }

    /**
     * 不带全局变量的 dfs，递推式dfs
     */
    public boolean hasPathSum1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val - targetSum == 0) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
