package tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yidxue
 * 1. 整体结构：递推式DFS, 先构造 root 节点，再构造 root.left 和 root.right 节点。
 * 2. 用一个 hashmap 记录中序遍历的结果
 * 3. 从先序遍历结果我们只能看出哪个是根节点，不知道左子树，右子树有多少个节点。。这个只能从中序遍历得到结果。
 * 4. 沿着第4条写，如何从中序遍历中拿到左子树，右子树的节点个数？答案：通过先序遍历确定的根节点 + 每轮的 inorderLeft 标记位。
 * 5. 写一句看上去废话的废话：preorderLeft/preorderRight 描述的是 preorder 数组。inorderRoot 描述的是 inorder 数组。
 */
public class Code105 {
    private Map<Integer, Integer> indexMap;

    public TreeNode myBuildTree(int[] preorder, int preorderLeft, int preorderRight, int inorderLeft) {
        if (preorderLeft > preorderRight) {
            return null;
        }

        // 1. 在中序遍历中定位根节点
        int inorderRoot = indexMap.get(preorder[preorderLeft]);
        // 2. 确定根节点在中序遍历位置，是为了确定左子树个数，注意这里是不需要 +1 的
        int sizeLeftSubtree = inorderRoot - inorderLeft;
        // 3. 根据先序遍历信息，把根节点建立出来
        TreeNode root = new TreeNode(preorder[preorderLeft]);
        // 4. 递归地构造左子树，并连接到根节点
        root.left = myBuildTree(preorder, preorderLeft + 1, preorderLeft + sizeLeftSubtree, inorderLeft);
        // 5. 递归地构造右子树，并连接到根节点
        root.right = myBuildTree(preorder, preorderLeft + sizeLeftSubtree + 1, preorderRight, inorderRoot + 1);
        return root;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        // 构造哈希映射，帮助我们快速定位根节点
        indexMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, 0, n - 1, 0);
    }
}
