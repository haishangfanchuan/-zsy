package leetcode.tree;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class 二叉树中的列表 {

    public static void main(String[] args) {
        Integer[] tree = {1,2,3,4,5,6,7,8,9,10,11};
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        二叉树中的列表 c = new 二叉树中的列表();
        c.createTreeNode(tree,linkedList);
        System.out.println(linkedList.get(0));
        c.preOrderTraverse(linkedList.get(0));
    }

    //将数组生成二叉树
    public void createTreeNode(Integer[] tree, LinkedList<TreeNode> linkedList){
        for (int i = 0; i <tree.length ; i++) {
            linkedList.add(new TreeNode(tree[i]));
        }
        for (int i = 0; i <tree.length/2-1 ; i++) {
            linkedList.get(i).leftNode = linkedList.get(i*2+1);
            linkedList.get(i).rightNode = linkedList.get(i*2+2);
        }
        //因为最后一个父节点可能没有右孩子（为奇数有，为偶数没有）
        int lastNode = tree.length/2- 1;
        linkedList.get(lastNode).leftNode = linkedList.get(lastNode*2+1);
        if(lastNode%2==1){
            linkedList.get(lastNode).rightNode = linkedList.get(lastNode*2+2);
        }
    }

    //先序遍历
    public List<Integer> preOrderTraverse(TreeNode treeNode){
        List<Integer> list = new ArrayList<>();
        if(treeNode==null){
            return list;
        }
        System.out.println("先序遍历-->"+treeNode.val);
        list.add(treeNode.val);
        System.out.println(list);
        preOrderTraverse(treeNode.leftNode);
        preOrderTraverse(treeNode.rightNode);
        return list;
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null){
            return true;
        }
        if(root==null) {
            return false;
        }
        if(root.val==head.val) {
            return isSubPath(head.next,root.rightNode)||
                    isSubPath(head.next,root.leftNode);
        }else{
            return isSubPath(head,root.rightNode)||
                    isSubPath(head,root.leftNode);
        }
    }

}

class TreeNode{
    int val;
    TreeNode leftNode;
    TreeNode rightNode;
    public TreeNode(int val){
        this.val = val;
    }
}
class ListNode{
    int val;
    ListNode next;
    public ListNode(int val) {
        this.val = val;
    }
}

