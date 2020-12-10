package jiangzhi_offer;

import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/17 12:50
 */
public class 用两个栈实现队列 {

    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        if(stack1.isEmpty())  stack1.push(node);
        else{
            while (!stack1.isEmpty()){
                stack2.push(stack1.pop());
            }
            stack1.push(node);
            while (!stack2.isEmpty()){
                stack1.push(stack2.pop());
            }
        }
    }

    public int pop() {
        if(stack1.isEmpty()) throw new NullPointerException("栈为空！");
        return stack1.pop();
    }
}
