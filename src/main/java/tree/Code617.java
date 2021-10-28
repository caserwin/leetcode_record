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

        TreeNode resNode = new Code617().mergeTrees3(null, null);
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


    /**
     * 这是一个错误解法
     */
    public TreeNode mergeTrees2(TreeNode t1, TreeNode t2) {
        TreeNode treeNode = null;
        dfs2(treeNode, t1, t2);
        return treeNode;
    }


    void dfs2(TreeNode treeNode, TreeNode r1, TreeNode r2) {
        if (treeNode == null) {
            treeNode = new TreeNode(0);
        }

        // 如果 r1和r2中，任意一个是null，函数就直接返回
        if (r1 == null || r2 == null) {
            if (r1 != null) {
                treeNode.val = r1.val;
            }
            if (r2 != null) {
                treeNode.val = r2.val;
            }
            return;
        }

        //否则把 r2 节点上的数值加到 r1 上。
        treeNode.val = r1.val + r2.val;
        if (r1.left != null || r2.left != null) {
            dfs2(treeNode.left, r1.left, r2.left);
        }
        if (r1.right != null || r2.right != null) {
            dfs2(treeNode.right, r1.right, r2.right);
        }
    }


    /**
     * 还是错误的，但是基于 mergeTrees2 做了修改
     */
    public TreeNode mergeTrees3(TreeNode t1, TreeNode t2) {
        TreeNode treeNode = new TreeNode(0);
        dfs3(treeNode, t1, t2);
        return treeNode;
    }

    void dfs3(TreeNode treeNode, TreeNode r1, TreeNode r2) {
        // 如果 r1和r2中，任意一个是null，函数就直接返回
        if (r1 == null || r2 == null) {
            if (r1 != null) {
                treeNode.val = r1.val;
            }
            if (r2 != null) {
                treeNode.val = r2.val;
            }
            return;
        }

        //否则把 r2 节点上的数值加到 r1 上。
        treeNode.val = r1.val + r2.val;
        if (r1.left != null || r2.left != null) {
            treeNode.left = new TreeNode(0);
            dfs3(treeNode.left, r1.left, r2.left);
        }
        if (r1.right != null || r2.right != null) {
            treeNode.right = new TreeNode(0);
            dfs3(treeNode.right, r1.right, r2.right);
        }
    }
}
