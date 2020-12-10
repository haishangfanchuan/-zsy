package jiangzhi_offer;

import leetcode.letcode100.comment.TreeNode;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/17 0:05
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class 重建二叉树 {

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        System.out.println(reConstructBinaryTree(pre,in));
     }

    public static TreeNode reConstructBinaryTree(int [] pre, int [] in) {
        if(pre==null || in == null
                ||pre.length==0 || in.length==0) return null;
        //创建根节点
        TreeNode root = new TreeNode(pre[0]);
        if(pre.length == 1) return root;

        int rootIndex = 0 ;
        for (int i = 0; i < in.length; i++) {
            if(in[i] == pre[0]){
                rootIndex = i;
                break;
            }
        }
        root.left = reConstructBinaryTree(Arrays.copyOfRange(pre,1,rootIndex + 1)
                ,Arrays.copyOfRange(in,0,rootIndex));
        root.right = reConstructBinaryTree(Arrays.copyOfRange(pre,rootIndex + 1,pre.length)
                ,Arrays.copyOfRange(in,rootIndex,in.length));
        return root;
    }


}
