package niucode;

import niucode.comment.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shengyun
 * @date 2021/1/8
 *
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 *              8
 *            /   \
 *           6     6
 *          / \   / \
 *         7   5 5   7
 *        /
 *       10
 *         \
 *          12
 */
public class 对称二叉树 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        TreeNode node1 = new TreeNode(6);
        TreeNode node2 = new TreeNode(6);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        TreeNode node6 = new TreeNode(5);
        TreeNode node10= new TreeNode(10);
        TreeNode node12 = new TreeNode(12);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
//        node3.left = node10;
//        node10.right = node12;

        node2.left = node6;
        node2.right = node5;
        对称二叉树 s = new 对称二叉树();
        System.out.println(root);
        System.out.println(s.isSymmetrical2(root));
    }

    //递归
    public  boolean isSymmetrical2(TreeNode pRoot) {
        if (pRoot == null || (pRoot.left == null && pRoot.right == null)) return true;
        if (pRoot.left == null || pRoot.right == null) return false;
        //反转左子树，拿过去和右子树对比
        TreeNode left = pRoot.left;
        flipTree(left);
        System.out.println(left);
        System.out.println(pRoot.right);
        return treeEquals(left,pRoot.right);
    }

    private boolean treeEquals(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        return treeEquals(t1.left,t2.left) && treeEquals(t1.right,t2.right);
    }

    public void flipTree(TreeNode treeNode) {
        if (treeNode == null || (treeNode.left == null && treeNode.right == null)) return;
        TreeNode right = treeNode.right;
        TreeNode left = treeNode.left;
        treeNode.left = right;
        treeNode.right = left;
        flipTree(left);
        flipTree(right);
    }


    //非递归
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        if (pRoot.left == null && pRoot.right == null) return true;
        //bsf
        Deque<TreeNode> deque = new ArrayDeque<>();
        Deque<Integer> dequeLast = new ArrayDeque<>();
        Deque<Integer> dequeFirst = new ArrayDeque<>();
        deque.add(pRoot);
        int floorNodeNum = deque.size(), count = 0;
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            count++;
            if (pop.left != null) {
                deque.add(pop.left);
                dequeLast.addLast(pop.left.val);
                dequeFirst.addFirst(pop.left.val);
            }else {
                dequeLast.addLast(-1);
                dequeFirst.addFirst(-1);
            }
            if (pop.right != null) {
                deque.add(pop.right);
                dequeLast.addLast(pop.right.val);
                dequeFirst.addFirst(pop.right.val);
            }else {
                dequeLast.addLast(-1);
                dequeFirst.addFirst(-1);
            }
            //该层数据已收集完毕
            if (floorNodeNum == count) {
                floorNodeNum = deque.size();
                count = 0;
                if (!stackEquals(dequeFirst, dequeLast)) return false;
                dequeFirst.clear();
                dequeLast.clear();
            }
        }
        return true;
    }

    boolean stackEquals(Deque<Integer> deque1, Deque<Integer> deque2) {
        int count = 0;
        if (deque1.isEmpty() && deque2.isEmpty()) return true;
        while (!deque1.isEmpty() && !deque2.isEmpty()) {
            count++;
            int val1 = deque1.pop();
            int val2 = deque2.pop();
            if (val1 != val2) return false;
        }
        return count > 1;
    }
}
