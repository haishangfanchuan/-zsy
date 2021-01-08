package niucode;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author shengyun
 * @date 2020/12/25
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 * 示例1
 * 输入
 * [4,8,6,12,16,14,10]
 * [4,6,8,10,12,14,16]
 * 返回值
 * true
 */
public class 二叉搜索树的后序遍历序列 {

    public static void main(String[] args) {
        System.out.println(VerifySquenceOfBST(new int[]{4,8,6,12,16,14,10}));
    }

    public static boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        if (sequence.length == 1) return true;
        //判断中序遍历是否能还原成BST
        int len = sequence.length;
        int[] mid = Arrays.copyOf(sequence, len);
        Arrays.sort(mid);
        return isPopToMid(mid,sequence);
    }

    private static boolean isPopToMid(int [] mid,int [] sequence) {
        Stack<Integer> stack = new Stack<>();
        int status = 0;
        stack.push(mid[status]);
        for (int i = 0; i < sequence.length; i++) {
            while (stack.isEmpty() || stack.peek() != sequence[i]) {
                status++;
                if (status >= sequence.length) return false;
                stack.push(mid[status]);
            }
            stack.pop();
        }
        return true;
    }
}
