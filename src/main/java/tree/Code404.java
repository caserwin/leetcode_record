package tree;

/**
 * @author yidxue
 */
public class Code404 {
//    public static void main(String[] args) {
//        TreeNode treeNode1 = new TreeNode(5);
//        TreeNode treeNode2 = new TreeNode(4);
//        TreeNode treeNode3 = new TreeNode(8);
//        TreeNode treeNode4 = new TreeNode(11);
//        TreeNode treeNode5 = new TreeNode(13);
//        TreeNode treeNode6 = new TreeNode(4);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode8 = new TreeNode(2);
//        TreeNode treeNode9 = new TreeNode(1);
//
//        treeNode1.left = treeNode2;
//        treeNode1.right = treeNode3;
//
//        treeNode2.left = treeNode4;
//
//        treeNode3.left = treeNode5;
//        treeNode3.right = treeNode6;
//
//        treeNode4.left = treeNode7;
//        treeNode4.right = treeNode8;
//
//        treeNode6.right = treeNode9;
//
//        System.out.println(new Code404().sumOfLeftLeaves(treeNode1));
//    }

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
}
