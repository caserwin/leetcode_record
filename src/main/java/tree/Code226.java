package tree;

/**
 * User: caserwin
 * Date: 2021/10/2 4:32 下午
 * Description:
 */
public class Code226 {
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        return root;
    }

    private void invert(TreeNode root){
        if (root == null){
            return;
        }
        TreeNode tmpNode = root.left;
        root.left = root.right;
        root.right = tmpNode;

        invert(root.left);
        invert(root.right);
    }
}
