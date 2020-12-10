package leetcode.letcode100;

/**
 * @author zhangsy
 * @date 2020/9/7 16:32
 */

import leetcode.letcode100.comment.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 给定一个二叉树，返回其节点值自底向上的层次遍历。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）

 例如：
 给定二叉树 [3,9,20,null,null,15,7],

    3
    / \
    9  20
    /  \
    15   7
    返回其自底向上的层次遍历为：

    [
    [15,7],
    [9,20],
    [3]
    ]
 */
public class 二叉树的层次遍历2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> listParent = new LinkedList<>();
        if(root==null ) return listParent;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);//向队列的队尾添加元素
        while (!queue.isEmpty()){

            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left!=null) queue.add(node.left);
                if(node.right!=null) queue.add(node.right);
            }
            listParent.add(0,list);
        }

        return listParent;
    }
}
