package top.theonecyl.datastructrue.tree;

/**
 * 二叉树的前序遍历
 *  1、父节点-> 左孩子节点->右孩子节点
 */
public class BinaryTree {
    private TreeNode  root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }


    //添加节点
    public void addNode(TreeNode treeNode){
        this.root.addNode(treeNode);
    }

    //根据编号查找节点
    public TreeNode queryNode(int no){
        if(this.root.queryNode(no)==root){
            return null;
        }else {
            return this.root.queryNode(no);
        }
    }

    //根据no删除节点
    public void delNode(int no){

        if(root!=null){
            if(root.getNo()==no){
                root=null;
            }else {
                root.delNode(no);
            }
        }else {
            System.out.println("数为空！！！");
        }
    }

    //前序遍历
    public void preOrder(){
        root.preOder();
    }
    //后续遍历
    public void postOrder(){
        this.root.postOrder();
    }

    //中序遍历
    public void midOrder(){
        this.root.midOrder();
    }
}
