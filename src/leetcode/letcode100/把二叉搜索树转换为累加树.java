package leetcode.letcode100;

import leetcode.letcode100.comment.TreeNode;

/**
 * @author zhangsy
 * @date 2020/9/21 22:00
 * <p>
 * 给定一个二叉搜索树（Binary Search Tree），把它转换成为累加树（Greater Tree)，
 * 使得每个节点的值是原来的节点值加上所有大于它的节点值之和。
 * 例如：
 * <p>
 * 输入: 原始二叉搜索树:
 * 5
 * /   \
 * 2     13
 * <p>
 * 输出: 转换为累加树:
 * 18
 * /   \
 * 20     13
 */
public class 把二叉搜索树转换为累加树{

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode leftNode = new TreeNode(2);
        TreeNode rightNode = new TreeNode(13);
        root.left = leftNode;root.right = rightNode;
        System.out.println(convertBST(root));
    }


    private  static int num = 0;

    public static TreeNode convertBST(TreeNode root) {
        //中序遍历累加
        if (root!=null) {
            convertBST(root.right);
            root.val = root.val + num;
            num = root.val;
            convertBST(root.left);
            return root;
        }
        return  null;
    }
}
