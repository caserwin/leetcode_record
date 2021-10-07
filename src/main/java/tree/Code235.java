package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code235 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        List<TreeNode> list2 = new ArrayList<>();

        iter(root, list1, p);
        iter(root, list2, q);

        int len = Math.min(list1.size(), list2.size());
        TreeNode ancestor = null;
        for (int i = 0; i < len; ++i) {
            if (list1.get(i) == list2.get(i)) {
                ancestor = list1.get(i);
            } else {
                break;
            }
        }
        return ancestor;
    }

    private void iter(TreeNode root, List<TreeNode> list, TreeNode node) {
        if (root == node) {
            list.add(node);
            return;
        }
        list.add(root);
        if (node.val >= root.val) {
            iter(root.right, list, node);
        } else {
            iter(root.left, list, node);
        }
    }
}
