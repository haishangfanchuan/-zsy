package niucode;

import niucode.comment.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengyun
 * @date 2020/12/25
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 	    8
 * 	   /  \
 * 	  6   10
 * 	 / \  / \
 * 	5  7 9  11
 */
public class 二叉树中和为某一值的路径 {

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Deque<Integer> deque = new ArrayDeque<>();
        dfs(root,target,list,deque);
        return list;
    }

    private void dfs(TreeNode root, int target, ArrayList<ArrayList<Integer>> list,Deque<Integer> deque) {
        if (root == null) return;
        deque.add(root.val);
        target = root.val - target;
        if (target == 0 && root.left == null && root.right == null) {
            list.add(new ArrayList<>(deque));
        }else {
            if (root.left != null) dfs(root.left,target,list,deque);
            if (root.right != null) dfs(root.right,target,list,deque);
        }
        deque.removeLast();
    }
}
