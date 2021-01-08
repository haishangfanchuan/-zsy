package niucode;

import niucode.comment.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author shengyun
 * @date 2020/12/24
 * @Description 从上往下打印出二叉树的每个节点，同层节点从左至右打印
 */
public class 从上往下打印二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode l1 = new TreeNode(3);
        TreeNode r1 = new TreeNode(4);
        root.left = l1;
        root.right = r1;
        l1.right = new TreeNode(4);
        r1.left = new TreeNode(6);
        System.out.println(PrintFromTopToBottom(root));
    }

    public static ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Deque<TreeNode> deque = new LinkedList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            TreeNode node = deque.poll();
            if (node == null) break;
            list.add(node.val);
            if (node.right != null) deque.addLast(node.right);
            if (node.left != null) deque.addLast(node.left);
        }
        return list;
    }
}
