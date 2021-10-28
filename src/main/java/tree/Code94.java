package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        dfs(root, resList);
        return resList;
    }

    private void dfs(TreeNode root, List<Integer> resList) {
        if (root == null){
            return;
        }
        dfs(root.left, resList);
        resList.add(root.val);
        dfs(root.right, resList);
    }
}
