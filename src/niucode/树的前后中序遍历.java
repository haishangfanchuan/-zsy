package niucode;

import niucode.comment.TreeNode;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/6 15:39
 */
public class 树的前后中序遍历 {

    /**
     *
     * @param root TreeNode类 the root of binary tree
     * @return int整型二维数组
     */
    public int[][] threeOrders (TreeNode root) {
        // write code here
        int[][] ints = new int[3][1];
        return null;
    }

    private int[] prePrint(TreeNode treeNode){
        int[] ints = new int[1];
        ints[0] = treeNode.val;
        if(treeNode.left!=null) {
            treeNode = treeNode.left;
            prePrint(treeNode);
            int[] copy = Arrays.copyOf(ints, ints.length + 1);
//            copy[]
        }
        return null;
    }
    private int[] midPrint(TreeNode treeNode){
        return null;
    }
    private int[] lastPrint(TreeNode treeNode){
        return null;
    }
}
