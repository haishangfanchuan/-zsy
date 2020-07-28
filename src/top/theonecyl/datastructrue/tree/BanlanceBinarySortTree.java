package top.theonecyl.datastructrue.tree;

/**
 * 平衡搜索二叉树
 */
public class BanlanceBinarySortTree {
    private TreeNode root;

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getRoot() {
        return root;
    }

    //查找结点
    public TreeNode search(int no){
        if(root==null){
            System.out.println("树为空");
            return null;
        }else {
            return root.searchBinaryTreeNode(no);
        }
    }


    //添加节点
    public void addNode(TreeNode treeNode){
        if(root!=null){
            root.valTreeAddNode(treeNode);
            if(root.getRightTreeHeight()-root.getLeftTreeHeight()>1){
                System.out.println("***********"+root+"*****进行了左旋转****");
                this.root.leftRotate();
            }
            if(root.getLeftTreeHeight()-root.getRightTreeHeight()>1){
                System.out.println("***********"+root+"*****进行了右旋转****");
                this.root.rightRotate();
            }
        }else {
            root = treeNode;
        }
    }






    public void preOrder() {
        if(root!=null){
            root.preOder();
        }else {
            System.out.println("此二叉树为空！");
        }
    }
    public void postOrder() {
        if(root!=null){
            root.postOrder();
        }else {
            System.out.println("此二叉树为空！");
        }
    }
    public void midOrder() {
        if(root!=null){
            root.midOrder();
        }else {
            System.out.println("此二叉树为空！");
        }
    }
}
