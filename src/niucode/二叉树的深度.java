package niucode;

import niucode.comment.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author shengyun
 * @date 2020/12/31
 */
public class 二叉树的深度 {

    public int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return Math.max(TreeDepth(root.left),TreeDepth(root.right)) + 1;
    }

    /**
     * 非递归实现,寻找树的层数，bfs
     * @param root
     * @return
     */
    public int TreeDepth2(TreeNode root) {
        if (root == null) return 0;
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.add(root);
        int floorNodeNum = deque.size(), count = 0,res = 0;
        while (!deque.isEmpty()) {
            TreeNode pop = deque.pop();
            count++;
            if (pop.left != null) {
                deque.add(pop.left);
            }
            if (pop.right != null) {
                deque.add(pop.right);
            }
            if (count == floorNodeNum) {
                floorNodeNum = deque.size();
                count = 0;
                res++;
            }
        }
        return res;
    }
}
