package tree;

/**
 * @author yidxue
 * 验证二叉搜索树
 */
public class Code98 {
    public static void main(String[] args) {
        TreeNode treeNode = TreeDataSource.getTreeNode3();
        System.out.println(new Code98().isValidBST(treeNode));
    }

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean is = true;
        if (root.right != null) {
            int a = getRightNum(root.right);
            is = is & root.val < a & isValidBST(root.right);
        }

        if (root.left != null) {
            int b = getLeftNum(root.left);
            is = is & root.val > b & isValidBST(root.left);
        }
        return is;
    }

    // 还要获取右子树的最小值
    private int getRightNum(TreeNode root) {
        if (root == null) {
            return Integer.MAX_VALUE;
        }
        return Math.min(Math.min(root.val, getRightNum(root.right)), getRightNum(root.left));
    }


    // 还要获取左子树的最大值
    private int getLeftNum(TreeNode root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }
        return Math.max(Math.max(root.val, getLeftNum(root.left)), getLeftNum(root.right));
    }

    /**
     * 提交的一版错误答案，要想想为什么？？
     */
    public boolean isValidBST1(TreeNode root) {
        if (root == null) {
            return true;
        }

        boolean is = true;
        if (root.right != null) {
            is = is & root.val < root.right.val & isValidBST1(root.right);
        }

        if (root.left != null) {
            is = is & root.val > root.left.val & isValidBST1(root.left);
        }
        return is;
    }
}
