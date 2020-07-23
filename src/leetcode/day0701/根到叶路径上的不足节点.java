package leetcode.day0701;


import java.util.LinkedList;
import java.util.List;

/**
 * 给定一棵二叉树的根 root，请你考虑它所有从根到叶的路径：从根到任何叶的路径。
 * （所谓一个叶子节点，就是一个没有子节点的节点）
 假如通过节点 node 的每种可能的 “根-叶” 路径上值的总和全都小于给定的 limit，则该节点被称之为「不足节点」，需要被删除。
 请你删除所有不足节点，并返回生成的二叉树的根。
 */
public class 根到叶路径上的不足节点 {

    public static void main(String[] args) {
        LinkedList<Object> linkedList = new LinkedList<>();
        Object[] tree = {1,2,3,4,-99,-99,7,8,9,-99,-99,12,13,-99,14};
        for (int i = 0; i <tree.length ; i++) {
            linkedList.add(tree[i]);
        }
        根到叶路径上的不足节点 c = new 根到叶路径上的不足节点();
        TreeNode treeNode = c.createTree(linkedList);
        System.out.println(treeNode);
        System.out.println(c.sufficientSubset(treeNode,22));
    }

    public TreeNode sufficientSubset(TreeNode root, int limit) {
        //遍历二叉树
        if(root==null){
            return null;
        }
        //就只有一个节点(根节点)
        if(root.left==root.right){
            if(root.val<limit){
                return null;
            }
            return root;
        }
        root.left = sufficientSubset(root.left, limit - root.left.val);
        root.right = sufficientSubset(root.right, limit - root.right.val);
        if(root.right==null&&root.left==null){
            return null;
        }
        return root;
    }

    private TreeNode createTree(LinkedList<Object> linkedList){
        if(linkedList==null||linkedList.isEmpty()){
            return null;
        }
        Integer date = (Integer) linkedList.removeFirst();
        TreeNode treeNode = null;
        if(date!=null){
            treeNode = new TreeNode(date);
            treeNode.left= createTree(linkedList);
            treeNode.right= createTree(linkedList);
        }
        return treeNode;
    }
}
class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) {
         val = x;
     }

    @Override
    public String toString() {
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
