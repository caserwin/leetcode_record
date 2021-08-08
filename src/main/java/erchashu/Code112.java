package erchashu;

/**
 * User: caserwin
 * Date: 2021/8/8 2:18 下午
 * Description:
 *
 * @author yidxue
 */
public class Code112 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        treeNode6.right = treeNode9;

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

    public boolean hasPathSumV1(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        if (root.left == null && root.right == null && root.val - targetSum == 0) {
            return true;
        }

        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }
}
