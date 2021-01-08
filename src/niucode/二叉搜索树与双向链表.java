package niucode;

import niucode.comment.TreeNode;

/**
 * @author shengyun
 * @date 2020/12/28
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
 * 要求不能创建任何新的结点，只能调整树中结点指针的指向。
 *          8
 *         / \
 *        5   10
 *       / \    \
 *      4   6    12
 *     /
 *    3
 */
public class 二叉搜索树与双向链表 {


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
        TreeNode convert = Convert(root);
    }

    private static TreeNode pre = null;
    private static TreeNode head = null;

    public static TreeNode Convert(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        convertMid(pRootOfTree);
        return head;
    }
    private static void convertMid(TreeNode cur) {
        if (cur == null) return;
        convertMid(cur.left);
        if (head == null) {
            pre = cur;
            head = cur;
        }else {
            pre.right = cur;
            cur.left = pre;
            pre = cur;
        }
        convertMid(cur.right);
    }

}
