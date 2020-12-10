package jiangzhi_offer;

import leetcode.letcode100.comment.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangsy
 * @date 2020/9/21 22:12输入一颗二叉树的根节点和一个整数，
 * 按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 */
public class 二叉树中的和为某一值的路径 {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private Deque<Integer> deque = new LinkedList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {

        if(root == null ) return res;

        deque.add(root.val);
        target-=root.val;
        //找到和为目标值的路径，且已经到达叶子节点
        if (target == 0 && root.left==null && root.right == null)
            res.add(new ArrayList<>(deque));
        else {
            //递归左右节点
            FindPath(root.left,target);
            FindPath(root.right,target);
        }
        //移除最后一个元素
        deque.removeLast();
        return res;
    }
}
