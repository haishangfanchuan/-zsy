package leetcode.letcode100;

import leetcode.letcode100.comment.TreeNode;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/26 12:43
 * 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例:
 * 给定如下二叉树，以及目标和 sum = 22，
 * <p>
 * 5
 * / \
 * 4   8
 * /   / \
 * 11  13  4
 * /  \    / \
 * 7    2  5   1
 * 返回:
 * <p>
 * [
 * [5,4,11,2],
 * [5,8,4,5]
 * ]
 */
public class 路径总和2 {

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        dfs(res,deque,root,sum);
        return res;
    }

    private void dfs(List<List<Integer>> res, Deque<Integer> deque,TreeNode root,int num){
        if(root == null) return;
        int val = root.val;
        deque.add(val);
        if(num==root.val && root.left==null && root.right==null){
            res.add(new ArrayList<>(deque));
            deque.removeLast();
            return;
        }
        dfs(res,deque,root.left,num - val);
        dfs(res,deque,root.right,num - val);
        deque.removeLast();
    }
}
