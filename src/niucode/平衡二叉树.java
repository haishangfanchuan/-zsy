package niucode;

import niucode.comment.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;


/**
 * @author shengyun
 * @date 2021/1/4
 *
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，
 * 并且左右两个子树都是一棵平衡二叉树。
 *        8
 *       / \
 *      5   10
 *     / \    \
 *    4   6    12
 *   /
 *  3
 */
public class 平衡二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node10 = new TreeNode(10);
        TreeNode node4 = new TreeNode(4);
        TreeNode node6 = new TreeNode(6);
        TreeNode node12 = new TreeNode(12);
        TreeNode node3 = new TreeNode(3);
        root.left = node5;
        root.right = node10;
        node5.left = node4;
        node5.right = node6;
        node4.left = node3;
        node10.right = node12;
        System.out.println(IsBalanced_Solution(root));
    }

    public static boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) return true;
        int leftHigh = treeHigh(root.left);
        int rightHigh = treeHigh(root.right);
        if (Math.abs(leftHigh - rightHigh) > 1) return false;
        IsBalanced_Solution(root.left);
        IsBalanced_Solution(root.right);
        return true;
    }

    private static int treeHigh(TreeNode root) {
        if (root == null) return 0;
        return Math.max(treeHigh(root.left),treeHigh(root.right)) + 1;
    }
}
