package top.theonecyl.datastructrue.tree;

public class BinaryDemo {
    public static void main(String[] args) {
//        BinaryTree binaryTree = new BinaryTree();
//        TreeNode rootNode = new TreeNode(1);
//        TreeNode treeNode1 = new TreeNode(2);
//        TreeNode treeNode2 = new TreeNode(3);
//        TreeNode treeNode3 = new TreeNode(4);
//        TreeNode treeNode4 = new TreeNode(5);
//        TreeNode treeNode5 = new TreeNode(6);
//        TreeNode treeNode7 = new TreeNode(7);
//        TreeNode treeNode8 = new TreeNode(8);
//        binaryTree.setRoot(rootNode);
//        binaryTree.addNode(treeNode1);
//        binaryTree.addNode(treeNode2);
//        binaryTree.addNode(treeNode3);
//        binaryTree.addNode(treeNode4);
//        binaryTree.addNode(treeNode5);
//        binaryTree.addNode(treeNode7);
//        binaryTree.addNode(treeNode8);

//        BinarySortTree binarySortTree = new BinarySortTree();
//        int[] array  = new int[]{7,3,10,12,5,1,9};
//        for (int i = 0; i < array.length; i++) {
//            if(i==0){
//                binarySortTree.setRootNode(new TreeNode(array[0]));
//            }else {
//                binarySortTree.addNode(new TreeNode(array[i]));
//            }
//        }
//        binarySortTree.addNode(new TreeNode(2));
//        binarySortTree.setRootNode(rootNode);
//        binarySortTree.addNode(treeNode1);
//        binarySortTree.addNode(treeNode2);
//        binarySortTree.addNode(treeNode3);
//        binarySortTree.addNode(treeNode4);
//        binarySortTree.addNode(treeNode5);
//        binarySortTree.addNode(treeNode7);
//        binarySortTree.addNode(treeNode8);

//        rootNode.setLeftNode(treeNode1);
//        rootNode.setRightNode(treeNode2);
//        treeNode1.setLeftNode(treeNode3);
//        treeNode2.setLeftNode(treeNode4);
//        treeNode2.setRightNode(treeNode5);
//        treeNode4.setLeftNode(treeNode7);
//        treeNode4.setRightNode(treeNode8);

//        binarySortTree.preOrder();
//
//        TreeNode search = binarySortTree.search(10);
//        System.out.println("搜索到的节点为："+search);

//        binarySortTree.delNode(3);
//
//        binarySortTree.preOrder();

//        TreeNode treeNode = binaryTree.queryNode(33);
//        System.out.println(treeNode);
//
//        binaryTree.delNode(66);
//
//        binaryTree.preOrder();

        BanlanceBinarySortTree banlanceBinarySortTree = new BanlanceBinarySortTree();
        int[] array  = new int[]{12,9,7,6,20,13,21,10,5,22,23,25};
        for (int i = 0; i < array.length; i++) {
            banlanceBinarySortTree.addNode(new TreeNode(array[i]));
        }
//        banlanceBinarySortTree.addNode(new TreeNode(15));

        banlanceBinarySortTree.preOrder();
//        System.out.println("搜索到的树为："+banlanceBinarySortTree.search(3));
        System.out.println("此树高度为："+banlanceBinarySortTree.getRoot().getTreeHeight());
        System.out.println("左子树高度为："+banlanceBinarySortTree.getRoot().getLeftTreeHeight());
        System.out.println("右子树度为："+banlanceBinarySortTree.getRoot().getRightTreeHeight());
    }

}
