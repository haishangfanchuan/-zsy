package leetcode.letcode100;

import leetcode.letcode100.comment.TreeNode;

/**
 * @author zhangsy
 * @date 2020/9/25 13:21
 * <p>
 * 根据一棵树的中序遍历与后序遍历构造二叉树。
 * <p>
 * 注意:
 * 你可以假设树中没有重复的元素。
 * <p>
 * 例如，给出
 * <p>
 * 中序遍历 inorder = [9,3,15,20,7]
 * 后序遍历 postorder = [9,15,7,20,3]
 * 返回如下的二叉树：
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 */
public class 从中序与后序遍历序列构造二叉树 {


    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 && postorder.length == 0) return null;

        //找到根节点
        return  null;
    }

}
