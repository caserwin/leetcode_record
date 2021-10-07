package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code145 {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        iter(root, list);
        return list;
    }

    private void iter(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        iter(root.left, list);
        iter(root.right, list);
        list.add(root.val);
    }
}
