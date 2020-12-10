package leetcode.letcode100;

import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/9 12:19
 */
public class 两个栈实现队列<T> {

    public static void main(String[] args) {
        两个栈实现队列<Integer> c = new 两个栈实现队列<Integer>();
        c.push(1);
        c.push(2);
        c.push(3);
        while (!c.isEmpty()){
            System.out.println(c.pop());
        }
    }

    private Stack<T> stack1 = new Stack<>();
    private Stack<T> stack2 = new Stack<>();


    //入队列
    public void push(T t){
        if(t==null) throw new NullPointerException("数据不能为空!");

        if(stack1.isEmpty()){
            stack1.push(t);
        }else {
            //先把stack1的数据放到stack2中
            while (!stack1.isEmpty())   stack2.push(stack1.pop());
            //将存入的数据放到shack1中
            if(stack1.isEmpty())    stack1.push(t);
            //将stack2中的数据放入stack1中
            while (!stack2.isEmpty())   stack1.push(stack2.pop());
        }
    }

    //出队列
    public T pop(){
        return stack1.pop();
    }

    //判断队列是否为空
    public  boolean isEmpty(){
        return stack1.isEmpty();
    }
}
