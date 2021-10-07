package tree;

/**
 * @author yidxue
 */
public class Code617 {

    public static void main(String[] args) {
        TreeNode treeRoot1 = new TreeNode(1);
        treeRoot1.left = new TreeNode(3);
        treeRoot1.right = new TreeNode(2);
        treeRoot1.left.left = new TreeNode(5);

        TreeNode treeRoot2 = new TreeNode(2);
        treeRoot2.left = new TreeNode(1);
        treeRoot2.right = new TreeNode(3);
        treeRoot2.left.right = new TreeNode(4);
        treeRoot2.right.right = new TreeNode(7);

        TreeNode resNode = new Code617().mergeTrees(treeRoot1, treeRoot2);
        System.out.println(resNode);
    }

    /**
     * 直接把 t2 合并到 t1 上，最终返回的是合并后的 t1
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        return dfs(t1, t2);
    }


    TreeNode dfs(TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，任意一个是null，函数就直接返回
        if (r1 == null || r2 == null) {
            return r1 == null ? r2 : r1;
        }

        //否则把 r2 节点上的数值加到 r1 上。
        r1.val += r2.val;
        r1.left = dfs(r1.left, r2.left);
        r1.right = dfs(r1.right, r2.right);
        return r1;
    }
}
