package niucode;

/**
 * @author shengyun
 * @date 2021/1/8
 *
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class 二叉树的下一个节点 {

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        //1、该节点有右孩子,找出右孩子数的最左子节点
        if (pNode.right != null) {
            TreeLinkNode right = pNode.right;
            while (right.left != null) {
                right = right.left;
            }
            return right;
        }
        //2、该节点没有右孩子
        //找出该节点的父节点
        TreeLinkNode parent = pNode.parent;
        //2.1 该节点是父节点的左子树，父节点即为下一个节点
        if (parent == null || parent.left == pNode) return parent;
        //2.2 该节点是父节点的右子树
        else  {
            TreeLinkNode pParent = parent.parent;
            TreeLinkNode cur = parent;
            //找到有一个节点的左节点为 pParent
            while (pParent != null && pParent.left != cur) {
                pParent = pParent.parent;
                cur = pParent;
            }
            return pParent;
        }
    }
}

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode parent = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}
