package leetcode.letcode100;

import leetcode.letcode100.comment.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/14 15:08
 */
public class 二叉树的中序遍历 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = null;
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        System.out.println(inorderTraversal(root));
    }

    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        //判断：root!=null（叶子节点或者根节点） 或者   !stack.isEmpty();
        //root [8,5,4,6,,12,10,13]
        while (root != null || !stack.isEmpty()) {
            //找到最后一个左节点为空的节点
            while (root!=null && root.left != null) {
                root = root.left;
                //全部压入栈中
                stack.push(root);//左子树[8,5,4]
            }
            //找到左节点为空的节点，pop
            TreeNode pop = stack.pop();
            list.add(pop.val);
            //寻找右子节点
            root = pop.right;
            if(root!=null )stack.push(root);
        }
        return list;
    }

}
