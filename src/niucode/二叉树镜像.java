package niucode;

import niucode.comment.TreeNode;

/**
 * @author shengyun
 * @date 2020/12/24
 *
 * 二叉树的镜像定义：源二叉树
 *     	    8
 *     	   /  \
 *     	  6   10
 *     	 / \  / \
 *     	5  7 9 11
 *     	镜像二叉树
 *     	    8
 *     	   /  \
 *     	  10   6
 *     	 / \  / \
 *     	11 9 7  5
 */
public class 二叉树镜像 {

    public void Mirror(TreeNode root) {
        if (root == null) return;
        //交换左右节点
        TreeNode left = root.left;
        root.left = root.right;
        root.right = left;
        if (root.left != null) Mirror(root.left);
        if (root.right != null) Mirror(root.right);
    }
}
