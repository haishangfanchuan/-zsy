package jiangzhi_offer;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/19 23:49输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则返回true,否则返回false。假设输入的数组的任意两个数字都互不相同。
 */
public class 二叉树的后序遍历序列 {

    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence==null || sequence.length==0) return false;
        if(sequence.length == 1) return true;
        int[] clone = sequence.clone();
        Arrays.sort(clone);
        return IsPopOrder(sequence, clone);

    }
    public  boolean IsPopOrder(int [] pushA,int [] popA) {
        if(pushA.length==0 || popA.length==0) return false;
        Stack<Integer> stack = new Stack<>();
        int len = popA.length , pop = 0 , push = 0, count = 0;
        stack.push(pushA[0]);
        //全部压栈
        while (count < len) {
            //判断stack弹出的数字是否等于popA[i]
            while (stack.peek()==popA[pop]){
                stack.pop();
                if(stack.isEmpty() || count >= len) break;
                pop++;
            }
            count++;
            //继续压栈,压完为止
            if (push < len -1){
                stack.push(pushA[push + 1]);
                push++;
            }
        }
        //判断是否栈空
        return stack.isEmpty();
    }
}
