package top.theonecyl.datastructrue.stack;

import java.util.Arrays;

public class 栈模拟多数运算 {
    public static void main(String[] args) {
        TestStack<Integer> stack = new TestStack<>();
//        stack.push(1);
//        stack.push(2);
//        stack.push(3);
//        stack.list();
//        System.out.println("**********");
//        System.out.println(stack.pop());
//        System.out.println(stack.pop());
//        System.out.println("**********");
//        stack.list();


//        System.out.println(stack.getResult("4*3+4/2+8-4+6*5"));
//        定义数字栈
        TestStack<Integer> numberStack = new TestStack<>();
        //定义符号栈
        TestStack<Character> operatorStack = new TestStack<>();
        //运算时需要的变量
        String equation = "4*3";
        int num1 = 0;
        int num2 = 0;
        int result = 0;
        char c;//用于接收pop出来的数据
        int idnex = 0;//扫描运算式的指针
        while(true){
            c = equation.substring(idnex, ++idnex).charAt(0);
            if(stack.isOperator(c)){
                //如果栈为空就直接加入
                if(operatorStack.isEmpty()){
                    operatorStack.push(c);
                }else{
                    stack.isOperatorPush(num1,num2,c,result,numberStack,operatorStack);
                }
            }else {
                //是数字，直接加入数字栈
                numberStack.push(Integer.parseInt(String.valueOf(c)));
            }
            if(idnex>=equation.length()){
                break;
            }
        }
        System.out.println("*******index"+idnex);
        System.out.println(result);
    }
}
class TestStack<T>{

    //指向栈顶的指针
    private int pointStack = -1;

    private Object[] array = new Object[0];
    public boolean isEmpty(){
        return pointStack==-1;
    }

    public void push(T t){
        pointStack++;
        //数组长度加1
        array=Arrays.copyOf(array,array.length+1);
        array[pointStack] = t;
    }

    public T pop(){
        if(isEmpty()){
            System.out.println("栈空！");
            return null;
        }
        T t  = (T) array[pointStack];
        pointStack--;
        return t;
    }

    //遍历栈
    public void list(){
        for(int i=0;i<=pointStack;i++){
            System.out.println(array[i]);
        }
    }

    //判断是否为基础运算符
    public boolean isOperator(Character c){
        return c=='+'||c=='-'||c=='*'||c=='/';
    }

    //判断符号优先级
    public int priority(int operator){
        if(operator=='*'||operator=='/'){
            return 1;
        }else if(operator=='+'||operator=='-'){
            return 0;
        }else{
            return -1;
        }
    }

    //数字运算的方法
    public int getResult(int num1,int num2 ,int operator){
        int res = 0;
        switch (operator){
            case '*':
                res = num1*num2;
                break;
            case '/':
                res = num2/num1;
                break;
            case '+':
                res = num2+num1;
                break;
            case '-':
                res = num2-num1;
                break;
            default:
                break;
        }
        return res;
    }

    //获取栈顶运算符
    public Character topOperatorStack(){
//        System.out.println("**栈顶运算符**"+array[pointStack]+"**数组大小**"+pointStack);
        if(pointStack!=-1) {
            return (Character) array[pointStack];
        }else{
            return ' ';
        }
    }
    //判断运算符是否可以入栈
    public int isOperatorPush(int num1,int num2 ,char operator,int result,
                                  TestStack<Integer> numberStack,
                                  TestStack<Character> operatorStack){
        Character preOperator = operatorStack.topOperatorStack();
        if(priority(preOperator)>=priority(operator)&&
                priority(operator)!=-1&&
                preOperator!=' ')
        {
            //可以入栈
            //运算符先不入栈，等计算完毕在入栈
            preOperator = operatorStack.pop();
            num1 = numberStack.pop();
            num2 = numberStack.pop();
            result = numberStack.getResult(num1,num2,preOperator);
            //运算结果入数字栈
            numberStack.push(result);
            isOperatorPush(num1,num2,operator,result,numberStack,operatorStack);
            return result;
        }else{
            //新运算符入运算符栈
            operatorStack.push(operator);
            return result;
        }
    }
}


