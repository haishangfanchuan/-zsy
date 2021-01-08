package niucode;

import niucode.comment.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;

/**
 * @author shengyun
 * @date 2021/1/8
 *
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[10,6],[5,7,9,11]]
 */
public class 按之字形顺序打印二叉树 {

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        ArrayDeque<TreeNode> deque = new ArrayDeque<>();
        ArrayDeque<Integer> res = new ArrayDeque<>();
        deque.add(pRoot);
        res.add(pRoot.val);
        lists.add(new ArrayList<>(res));
        res.clear();
        int floor = 2, count = 0,size = deque.size();
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            count++;
            if (pop.left != null) {
                deque.add(pop.left);
                if (floor % 2 == 0) res.addFirst(pop.left.val);
                else res.addLast(pop.left.val);
            }
            if (pop.right != null) {
                deque.add(pop.right);
                if (floor % 2 == 0) res.addFirst(pop.right.val);
                else res.addLast(pop.right.val);
            }
            if (count == size) {
                size = deque.size();
                count = 0;
                floor++;
                if (!res.isEmpty()) lists.add(new ArrayList<>(res));
                res.clear();
            }
        }
        System.out.println(floor);
        return lists;
    }
}
