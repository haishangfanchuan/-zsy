package niucode.comment;

/**
 * @author zhangsy
 * @date 2020/9/6 15:40
 */
public class TreeNode {
   public int val;
    public TreeNode left = null;
    public TreeNode right = null;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
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
