package tree;

import java.util.*;

/**
 * @author yidxue
 */
public class Code236 {

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    /**
     * 记录每个节点的父节点
     */
    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    /**
     * 从目标节点向 root 节点搜索
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while (p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }

    /**
     * 以下是错误答案、为什么不能通过找路径的方式来找到 target
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
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
        if (root == null || root == node) {
            return;
        }
        list.add(root);
        iter(root.left, list, node);
        iter(root.right, list, node);
    }
}
