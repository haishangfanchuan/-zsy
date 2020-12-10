package jiangzhi_offer;

import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/19 23:03
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，
 * 序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。
 * （注意：这两个序列的长度是相等的）
 */
public class 栈的压入弹出 {

    public static void main(String[] args) {
        int[] pushA = {1,2,3,4,5};
        int[] popA = {4,3,5,1,2};
        System.out.println(IsPopOrder(pushA,popA));
    }

    public static boolean IsPopOrder(int [] pushA,int [] popA) {
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
