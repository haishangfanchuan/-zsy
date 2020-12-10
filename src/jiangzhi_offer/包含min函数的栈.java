package jiangzhi_offer;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/19 22:36
 */
public class 包含min函数的栈 {
    private Stack<Integer> stackDate = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();
    public void push(int node) {
        if(minStack.isEmpty()) minStack.push(node);
        else{
            Integer min = minStack.peek();
            if (node < min) minStack.push(node);
            stackDate.push(node);
        }
    }

    public void pop() {
        if (stackDate.isEmpty())
            throw new EmptyStackException();
        stackDate.pop();
    }

    public int top() {
        if (stackDate.isEmpty())
            throw new EmptyStackException();
        return stackDate.pop();
    }

    public int min() {
        if (stackDate.isEmpty())
            throw new EmptyStackException();
        return minStack.peek();
    }

    public static void main(String[] args) {
        包含min函数的栈 c = new 包含min函数的栈();
        c.push(1);
        c.push(2);
        c.push(3);
        c.push(4);
        c.push(0);
        System.out.println(c.min());
    }
}
