package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author yidxue
 */
public class Code129 {
    public static void main(String[] args) {

    }

    /**
     * 全局变量形式的 dfs，这句不太容易写成递推式的 dfs。
     * 可以理解为回溯算法，不太容易改成递推式的 dfs
     */
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root, "");
        int sum = 0;
        for (String num : list) {
            sum += Integer.parseInt(num);
        }
        return sum;
    }

    List<String> list = new ArrayList<>();

    private void dfs(TreeNode node, String str) {
        // 如果是叶节点，则直接添加元素到 List 中
        if (node.right == null && node.left == null) {
            str += node.val;
            list.add(str);
            return;
        }

        if (node.right != null) {
            dfs(node.right, str + node.val);
        }

        if (node.left != null) {
            dfs(node.left, str + node.val);
        }
    }
}
