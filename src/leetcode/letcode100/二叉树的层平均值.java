package leetcode.letcode100;

import leetcode.letcode100.comment.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/12 12:33
 *
 * 给定一个非空二叉树, 返回一个由每层节点平均值组成的数组。
    示例 1：

    输入：
    3
    / \
    9  20
    /  \
    15   7
    输出：[3, 14.5, 11]
    解释：
    第 0 层的平均值是 3 ,  第1层是 14.5 , 第2层是 11 。因此返回 [3, 14.5, 11] 。
 */
public class 二叉树的层平均值 {
    public static void main(String[] args) {
        int[] array = {3,9,20,15,7};
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);
        System.out.println(averageOfLevels(root));
    }

    public static List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new ArrayList<>();
        if(root==null) return list;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()){
            int size = deque.size(),count = 0;
            double avg = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.poll();
                count++;
                avg+=node.val;
                if(node.left!=null) deque.add(node.left);
                if(node.right!=null) deque.add(node.right);
            }

            list.add(avg/count);
        }
       return list;
    }
}
