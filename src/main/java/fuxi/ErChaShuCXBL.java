//package fuxi;
//
//import tree.TreeDataSource;
//import tree.TreeNode;
//
//import java.util.ArrayList;
//import java.util.LinkedList;
//import java.util.List;
//import java.util.Queue;
//
///**
// * User: caserwin
// * Date: 2023/6/10 2:17 下午
// * Description:
// */
//public class ErChaShuCXBL {
//    public static void main(String[] args) {
//        TreeNode treeNode1 = TreeDataSource.getTreeNode1();
//        new ErChaShuCXBL().levelOrder(treeNode1);
//    }
//
//    public List<List<Integer>> levelOrder(TreeNode root) {
//        List<List<Integer>> ret = new ArrayList<>();
//        if (root == null) {
//            return ret;
//        }
//
//        Queue<TreeNode> queue = new LinkedList<>();
//        queue.offer(root);
//
//    }
//}
