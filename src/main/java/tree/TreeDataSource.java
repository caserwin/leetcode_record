package tree;

/**
 * Date: 2021/10/10 3:59 下午
 */
public class TreeDataSource {

    public static TreeNode getTreeNode1() {
        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(8);
        TreeNode treeNode4 = new TreeNode(11);
        TreeNode treeNode5 = new TreeNode(13);
        TreeNode treeNode6 = new TreeNode(4);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(2);
        TreeNode treeNode9 = new TreeNode(1);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;

        treeNode3.left = treeNode5;
        treeNode3.right = treeNode6;

        treeNode4.left = treeNode7;
        treeNode4.right = treeNode8;

        treeNode6.right = treeNode9;
        return treeNode1;
    }

    public static TreeNode getTreeNode2() {
        //[1,2,3,4,null,null,5]
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;

        treeNode3.right = treeNode5;
        return treeNode1;
    }


    public static TreeNode getTreeNode3() {
        // [5,4,8,11,null,13,4,7,2,null,null,5,1]
        TreeNode treeNode1 = new TreeNode(5);
        TreeNode treeNode2 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(6);
        TreeNode treeNode4 = new TreeNode(3);
        TreeNode treeNode5 = new TreeNode(7);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode3.left = treeNode4;
        treeNode3.right = treeNode5;

        return treeNode1;
    }

    public static TreeNode getTreeNode4() {
        //[1,2,3,4,5]
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;

        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        return treeNode1;
    }
}