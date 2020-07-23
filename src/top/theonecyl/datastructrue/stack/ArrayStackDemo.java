package top.theonecyl.datastructrue.stack;

import java.util.Stack;

/**
 * 使用一维数组模拟栈
 */
public class ArrayStackDemo {
    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        while(!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

    }

}

class ArrayStack<T>{
    //定义存储数据的数组
    private Object[] stack;
    //栈的大小
    private int size;
    //定义一个指向栈顶的指针变量,初始为-1,代表栈为空
    private int stackPointer = -1;

    public ArrayStack(int size) {
        this.size = size;
        this.stack = new Object[size];
    }

    //压栈方法
    public void push(T t){
        stackPointer++;
        if(stackPointer<=size) {
            stack[stackPointer] = t;
        }else{
            //栈满
            System.out.println("栈已满");
        }
    }
    //出栈方法
    public T pop(){
        //找到栈顶位置，stackPointer
        if(stackPointer==-1){
            //栈为空
            System.out.println("栈为空！");
            return null;
        }
        T t = (T) stack[stackPointer];
        stackPointer--;
        return t;
    }

    //判断栈是否为空
    public boolean isEmpty(){
        return stackPointer==-1?true:false;
    }

}
