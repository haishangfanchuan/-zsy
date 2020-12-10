package leetcode.letcode100;

import leetcode.letcode100.comment.TreeNode;

/**
 * @author zhangsy
 * @date 2020/9/16 22:42
 * 翻转一棵二叉树。

示例：

输入：

4
/   \
2     7
/ \   / \
1   3 6   9
输出：

4
/   \
7     2
/ \   / \
9   6 3   1

 */
public class 翻转二叉树 {

    public TreeNode invertTree(TreeNode root) {
        if(root==null) return root;
        if(root.left!=null || root.right!=null){
            //交换左右节点
            TreeNode tempLeft = root.left;
            root.left = root.right;
            root.right = tempLeft;
            //递归向下翻转
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
