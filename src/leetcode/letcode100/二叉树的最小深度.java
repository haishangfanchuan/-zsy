package leetcode.letcode100;

import leetcode.letcode100.comment.TreeNode;

/**
 * @author zhangsy
 * @date 2020/9/7 14:24
 */
public class 二叉树的最小深度 {

    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        int ld = minDepth(root.left);
        int rd = minDepth(root.right);
        return root.left==null || root.right==null ? ld+rd+1 : Math.min(ld,rd)+1;
    }
}
