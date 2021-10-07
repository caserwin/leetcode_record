package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code144 {

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        iter(root, list);
        return list;
    }

    private void iter(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        list.add(root.val);
        iter(root.left, list);
        iter(root.right, list);
    }
}
