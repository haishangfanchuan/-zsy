package jiangzhi_offer;

import leetcode.letcode100.comment.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/19 14:28
 * <p>
 * 二叉树的镜像定义：源二叉树
 * 8
 * /  \
 * 6   10
 * / \  / \
 * 5  7 9 11
 * 镜像二叉树
 * 8
 * /  \
 * 10   6
 * / \  / \
 * 11 9 7  5
 */
public class 二叉树的镜像 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode nodeLeft = new TreeNode(6);
        TreeNode nodeRight = new TreeNode(10);
        TreeNode node = new TreeNode(5);
        TreeNode node1 = new TreeNode(7);
        TreeNode node2 = new TreeNode(9);
        TreeNode node3 = new TreeNode(11);
        root.left = nodeLeft;
        root.right = nodeRight;
        nodeLeft.left = node;
        nodeLeft.right = node1;
        nodeRight.left = node2;
        nodeRight.right = node3;
        System.out.println("转化为镜像之前===>"+printTreeCenXu(root));
        Mirror(root);
        System.out.println("转化为镜像之后===>"+printTreeCenXu(root));
    }

    public static void Mirror(TreeNode root) {
        if(root==null) return;
        if (root.left == null && root.right==null) return;
        //交换左右子节点
        TreeNode tempNode = root.left;
        root.left = root.right;
        root.right = tempNode;
        if(root.left!=null) Mirror(root.left);
        if(root.right!=null) Mirror(root.right);
    }


    //层序打印二叉树
    public static List<Integer> printTreeCenXu(TreeNode root){
        if(root==null) return null;
        Deque<TreeNode> deque = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        deque.add(root);
        while (!deque.isEmpty()) {
            for (int i = 0; i < deque.size(); i++) {
                TreeNode node = deque.pop();
                list.add(node.val);
                if(node.left!=null) deque.add(node.left);
                if(node.right!=null) deque.add(node.right);
            }

        }
        return list;
    }
}
