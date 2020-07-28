package top.theonecyl.datastructrue.tree;

/**
 * 二叉排序树
 */
public class BinarySortTree {
    //定义一个根节点
    private TreeNode root;

    public void setRootNode(TreeNode root) {
        this.root = root;
    }

    //添加节点
    public void addNode(TreeNode treeNode){
        if(root!=null){
            root.addBinarySortTreeNode(treeNode);
        }else {
            root = treeNode;
        }
    }

    //删除节点
    public void delNode(int no ){
        if(root!=null){
            if(this.root.getNo()==no){
                root=null;
            }else {
                root.delBinarySearchTreeNode(no);
            }
        }else {
            System.out.println("排序二叉树为空！");
        }
    }

    //查找结点
    public TreeNode search(int no){
        if(root==null){
            System.out.println("数为空");
            return null;
        }else {
            return this.root.searchBinaryTreeNode(no);
        }
    }

    public void preOrder() {
        if(root!=null){
            root.preOder();
        }else {
            System.out.println("此二叉树为空！");
        }
    }
}
