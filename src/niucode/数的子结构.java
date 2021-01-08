package niucode;

import niucode.comment.TreeNode;

/**
 * @author shengyun
 * @date 2020/12/10
 *
 */
public class 数的子结构 {

    public boolean HasSubtree(TreeNode root1, TreeNode root2) {

        //从root1根节点开始搜索，默认不是子树
        boolean flag = false;
        if (root1 != null && root2 != null) {

            if (root1.val == root2.val)
                flag = bfs(root1,root2);
            //不是子树,从左右节点开始搜索
            if (!flag){
                HasSubtree(root1.left,root2);
                HasSubtree(root1.right,root2);
            }
        }
        return flag;
    }

    private boolean bfs (TreeNode root1, TreeNode root2) {
        if (root2 == null) return true;
        if (root1 == null) return false;
        if (root1.val == root2.val) return true;
        return bfs(root1.left,root2.left) && bfs(root1.right,root1.right);
    }
}
