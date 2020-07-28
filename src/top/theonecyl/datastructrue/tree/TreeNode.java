package top.theonecyl.datastructrue.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 定义节点
 */
public class TreeNode {

    private static int count = 0;//搜索节点次数

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

    //二叉排序数添加节点
    public void addBinarySortTreeNode(TreeNode treeNode){

        if(this.getLeftNode()==null){
            if(treeNode.getNo()<this.getNo()){
                this.setLeftNode(treeNode);
                return;
            }
        }
        if(this.getRightNode()==null){
            //如果需要添加节点的值与父节点的值先等，则放在右子节点
            if(treeNode.getNo()>=this.getNo()){
                this.setRightNode(treeNode);
                return;
            }
        }

        if(treeNode.getNo() < this.getNo()){
            //向左子树遍历
            this.getLeftNode().addBinarySortTreeNode(treeNode);
        }

        if(treeNode.getNo()>this.getNo()){
            //向右遍历
            this.getRightNode().addBinarySortTreeNode(treeNode);
        }
    }

    //搜索二叉树查找节点
    public TreeNode searchBinaryTreeNode(int no){
        if(this.getNo() == no){
            count++;
            return this;
        }else {
            if(no>this.getNo()&&this.getRightNode()!=null){
                count++;
                //向右递归查找
                return this.getRightNode().searchBinaryTreeNode(no);
            }else if(no<this.getNo()&&this.getLeftNode()!=null){
                count++;
                //向左递归查找
                return this.getLeftNode().searchBinaryTreeNode(no);
            }else {
                System.out.println("不存在此节点！");
                return null;
            }
        }

    }

    //搜索二叉树删除节点
    public void delBinarySearchTreeNode(int no){
        //找到需要删除的节点
        if(this.getLeftNode()!=null && this.getLeftNode().getNo()==no){//删除左子节点
            this.setLeftNode(null);
            return;
        }
        if(this.getRightNode()!=null && this.getRightNode().getNo()==no ) {//删除右子节点
            this.setRightNode(null);
            return;
        }

        if(no>this.getNo()&& this.getRightNode()!=null){
            this.getRightNode().delBinarySearchTreeNode(no);
        }else if(no<this.getNo() && this.getLeftNode()!=null){
            this.getLeftNode().delBinarySearchTreeNode(no);
        }else {
            System.out.println("不存在此节点！");
        }
    }



    //树添加节点
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

    //****************************************************************
    //                      平衡二叉树                                 *
    //****************************************************************

    //判断当前节点左子树高速度
    public int getLeftTreeHeight(){
        if(this.getLeftNode()==null){
            return 0;
        }
       return this.getLeftNode().getTreeHeight()+1;
    }

    //判断当前节点右子树高度
    public int getRightTreeHeight(){
        if(this.getRightNode()==null){
            return 0;
        }
       return this.getRightNode().getTreeHeight()+1;
    }

    //判断当前节树的最大高度
    //在左右子树高度取最大值
    public int getTreeHeight(){
        return Math.max(this.getLeftNode()==null?0:this.getLeftNode().getTreeHeight()
                ,this.getRightNode()==null?0:this.getRightNode().getTreeHeight())+1;
    }

    //当树的       右子树高度 - 左子树高度  > 1  ---> 左旋转
    public  void leftRotate(){
        //1、创建一个新的节点
        TreeNode newNode = new TreeNode(this.getNo());
        //2、将新节点的左子树设置为当前节点的左子树
        newNode.setLeftNode(this.getLeftNode());
        //3、将新节点的右子树设置为当前节点右子树的左子树
        newNode.setRightNode(this.getRightNode().getLeftNode());
        //4、把当前节点的值设为右节点的值
        this.setNo(this.getRightNode().getNo());
        //5、把当前节点的右子树的设置为右子树的右子树
        this.setRightNode(this.getRightNode().getRightNode());
        //6、把当前节点的右子树的左子树设置为新的节点
        this.setLeftNode(newNode);
    }

    //当树的       左子树高度 - 右子树高度  > 1  ---> 右旋转
    public void rightRotate(){
        //1、新建一个节点
        TreeNode newNode = new TreeNode(this.getNo());
        //将新节点的右节点设置为当前节点的右节点
        newNode.setRightNode(this.getRightNode());
        //3、将新节点的左节点设置为当前节点左节点的右节点
        newNode.setLeftNode(this.getLeftNode().getRightNode());
        //4、将当前节点的值设置为左节点
        this.setNo(this.getLeftNode().getNo());
        //5、将当前节点的左节点设置为左节点的左节点
        this.setLeftNode(this.getLeftNode().getLeftNode());
        //6、将当前节点的右节点设置为新的节点
        this.setRightNode(newNode);
    }


    //平衡二叉树添加节点
    public void valTreeAddNode(TreeNode treeNode){
        if(treeNode==null){
            throw new RuntimeException("插入节点不能为空");
        }
        if(treeNode.getNo()>this.getNo()){
            //右边递归
            if(this.getRightNode()==null){//遇到右节点为空，添加节点
                this.setRightNode(treeNode);
                return;
            }
            this.getRightNode().valTreeAddNode(treeNode);
        }

        if(treeNode.getNo() < this.getNo()){
            //左边递归
            if(this.getLeftNode()==null){//遇到右节点为空，添加节点
                this.setLeftNode(treeNode);
                return;
            }
            this.getLeftNode().valTreeAddNode(treeNode);
        }
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

    //中序遍历
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
