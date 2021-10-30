package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Description: 二叉树展开为链表形式，该链表其实也是二叉树，但是没有left 节点
 * @author yidxue
 */
public class Code114 {
    public static void main(String[] args) {
        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
        new Code114().flatten(treeNode1);

        TreeNode treeNode = list.get(0);
        // 只打印右节点
        while (treeNode != null) {
            System.out.println(treeNode.val);
            treeNode = treeNode.right;
        }
    }

    static List<TreeNode> list = new ArrayList<>();

    public void flatten(TreeNode root) {
        // 先用先序遍历存为一个 List
        preorderTraversal(root, list);
        int size = list.size();
        // 从 List 中构建只有 right 部分节点的二叉树
        for (int i = 1; i < size; i++) {
            TreeNode prev = list.get(i - 1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    public void preorderTraversal(TreeNode root, List<TreeNode> list) {
        if (root != null) {
            list.add(root);
            preorderTraversal(root.left, list);
            preorderTraversal(root.right, list);
        }
    }
}
