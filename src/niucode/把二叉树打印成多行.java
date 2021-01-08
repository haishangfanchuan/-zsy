package niucode;

import niucode.comment.TreeNode;

import java.util.ArrayList;

/**
 * @author shengyun
 * @date 2021/1/8
 *
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 示例1
 * 输入
 * 复制
 * {8,6,10,5,7,9,11}
 * 返回值
 * 复制
 * [[8],[6,10],[5,7,9,11]]
 */
public class 把二叉树打印成多行 {

    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        ArrayList<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(pRoot);
        int start = 0;
        while (!nodeList.isEmpty()) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = nodeList.size();
            for (int i = start; i < size; i++) {
                TreeNode node = nodeList.get(i);
                list.add(node.val);
                start++;
                if (node.left != null)  nodeList.add(node.left);
                if (node.right != null) nodeList.add(node.right);
            }
            if (list.isEmpty()) return lists;
            lists.add(list);
        }
        return lists;
    }
}
