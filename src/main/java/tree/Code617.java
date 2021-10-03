package tree;

/**
 * @author yidxue
 */
public class Code617 {

    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        TreeNode newTrees = new TreeNode();
        merge(newTrees, root1, root2);
        return newTrees;
    }

    private void merge(TreeNode newTrees, TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return;
        } else if (root1 != null && root2 != null) {
            newTrees.val += root1.val;
            newTrees.val += root2.val;

            newTrees.left = new TreeNode();
            newTrees.right = new TreeNode();

            merge(newTrees.left, root1.left, root2.left);
            merge(newTrees.right, root1.right, root2.right);
        } else if (root1 == null && root2 != null) {
            newTrees.val += root2.val;

            newTrees.left = new TreeNode();
            newTrees.right = new TreeNode();
            merge(newTrees.left, null, root2.left);
            merge(newTrees.right, null, root2.right);
        } else {
            newTrees.val += root1.val;

            newTrees.left = new TreeNode();
            newTrees.right = new TreeNode();
            merge(newTrees.left, root1.left, null);
            merge(newTrees.right, root1.right, null);
        }
    }
}
