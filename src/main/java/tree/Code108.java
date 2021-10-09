package tree;

/**
 * User: caserwin
 * Date: 2021/10/6 10:19 上午
 * Description: 将有序数组转换为二叉搜索树
 * 技巧：
 * 1. 每次都是取中间数字为根节点
 * 2. 不带全局变量的 dfs， 参考104和 111的两种写法
 */
public class Code108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    public TreeNode helper(int[] nums, int left, int right) {
        // 之所以 left > right 是因为 right 一开始取值 nums.length - 1，left取值和 right取值是有可能相同的。
        if (left > right) {
            return null;
        }

        // 总是选择中间位置右边的数字作为根节点
        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}