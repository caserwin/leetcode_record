package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> resList = new ArrayList<>();
        iter(root, resList);
        return resList;
    }

    private void iter(TreeNode root, List<Integer> resList) {
        if (root == null){
            return;
        }
        iter(root.left, resList);
        resList.add(root.val);
        iter(root.right, resList);
    }
}
