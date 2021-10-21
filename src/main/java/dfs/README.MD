
回溯就是dfs算法：
1. [494 目标和](https://leetcode-cn.com/problems/target-sum/)
2. 22 括号生成
3. 46 全排列
4. 78 子集问题  （非常经典）

```
void dfs(TreeNode root) {
    if (root == null) {
        return;
    }
    dfs(root.left);
    dfs(root.right);
}
```

dfs 算法则不等价于回溯，参考二叉树的题目：
https://leetcode-cn.com/problems/binary-tree-paths/solution/er-cha-shu-de-suo-you-lu-jing-by-leetcode-solution/
https://leetcode-cn.com/problems/sum-of-left-leaves/solution/zuo-xie-zi-zhi-he-by-leetcode-solution/
