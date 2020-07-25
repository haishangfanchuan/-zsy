package top.theonecyl.datastructrue.tree;

/**
 * 定义节点
 */
public class TreeNode {

    private static int count = 0;

    private int no;

    private TreeNode leftNode;
    private TreeNode rightNode;

    public TreeNode(int no, String name, String nickName) {
        this.no = no;

    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public TreeNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TreeNode leftNode) {
        this.leftNode = leftNode;
    }

    public TreeNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TreeNode rightNode) {
        this.rightNode = rightNode;
    }

    public TreeNode(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "no=" + no +
                '}';
    }

    //添加节点
    public void addNode(TreeNode treeNode){

        if(this.leftNode==null){
            this.leftNode=treeNode;

            return;
        }
        if(this.rightNode==null){
            this.rightNode=treeNode;
            return;
        }
        if(this.getLeftNode()!=null) {
            this.getLeftNode().addNode(treeNode);
        }else if(this.getRightNode()!=null) {
            this.getRightNode().addNode(treeNode);
        }
    }

    //根据no删除节点
    public void delNode(int no){
        if(this.getLeftNode()!=null && this.leftNode.getNo()==no){
            this.setLeftNode(null);
            return;
        }
        if(this.getRightNode()!=null && this.getRightNode().getNo()==no){
            this.setRightNode(null);
            return;
        }

        if(this.getLeftNode()!=null){
            this.getLeftNode().delNode(no);
        }
        if(this.getRightNode()!=null){
            this.getRightNode().delNode(no);
        }
    }

    //根据编号查找节点
    public TreeNode queryNode(int no){

        if(this.no==no){
            count++;
            System.out.println("找到节点了"+this+"**********一共寻找了"+count);
            return this;
        }else{
            if(this.getLeftNode()!=null){
                count++;
                this.getLeftNode().queryNode(no);
            }
            if(this.getRightNode()!=null){
                count++;
                this.getRightNode().queryNode(no);
            }

        }
        return this;
    }

    //前序遍历
    public void preOder(){
        System.out.println(this);
        if(this.leftNode!=null){
            this.leftNode.preOder();
        }
        if(this.rightNode!=null){
            this.rightNode.preOder();
        }
    }

    //后序遍历
    public void postOrder(){
        if(this.leftNode!=null){
            this.leftNode.postOrder();
        }
        if(this.getRightNode()!=null){
            this.getRightNode().postOrder();
        }
        System.out.println(this);
    }

    //
    public void midOrder() {
        if(this.getLeftNode()!=null){
            this.leftNode.midOrder();
        }
        System.out.println(this);
        if(this.getRightNode()!=null){
            this.getRightNode().midOrder();
        }
    }
}
