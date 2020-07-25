package top.theonecyl.datastructrue.tree;

public class BinaryDemo {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        TreeNode rootNode = new TreeNode(1);
        TreeNode treeNode1 = new TreeNode(2);
        TreeNode treeNode2 = new TreeNode(3);
        TreeNode treeNode3 = new TreeNode(4);
        TreeNode treeNode4 = new TreeNode(5);
        TreeNode treeNode5 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        binaryTree.setRoot(rootNode);
        binaryTree.addNode(treeNode1);
        binaryTree.addNode(treeNode2);
        binaryTree.addNode(treeNode3);
        binaryTree.addNode(treeNode4);
        binaryTree.addNode(treeNode5);
        binaryTree.addNode(treeNode7);
        binaryTree.addNode(treeNode8);

//        rootNode.setLeftNode(treeNode1);
//        rootNode.setRightNode(treeNode2);
//        treeNode1.setLeftNode(treeNode3);
//        treeNode2.setLeftNode(treeNode4);
//        treeNode2.setRightNode(treeNode5);
//        treeNode4.setLeftNode(treeNode7);
//        treeNode4.setRightNode(treeNode8);

        binaryTree.preOrder();

        TreeNode treeNode = binaryTree.queryNode(33);
        System.out.println(treeNode);

        binaryTree.delNode(66);

        binaryTree.preOrder();
    }
}
