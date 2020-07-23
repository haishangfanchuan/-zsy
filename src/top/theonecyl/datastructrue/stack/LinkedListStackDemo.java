package top.theonecyl.datastructrue.stack;


/**
 * 使用单链表模拟栈
 */
public class LinkedListStackDemo {
    public static void main(String[] args) {
        LinkedListStack linkedListStack = new LinkedListStack();
        linkedListStack.push(new StackNode(1));
        linkedListStack.push(new StackNode(2));
        linkedListStack.push(new StackNode(3));
        while (!linkedListStack.isEmpty()){
            System.out.println(linkedListStack.pop());
        }

    }
}

class LinkedListStack{
    //定义一个指针节点,指向栈顶，-1为栈空
    private StackNode headNode = new StackNode(-1);

    //判断栈是否为空
    public boolean isEmpty(){

        return headNode.getNext()==null?true:false;
    }

    //入栈操作
    public void push(StackNode stackNode){
        StackNode pointerNode = headNode;
        while(true) {
            if(pointerNode.getNext()==null) {
                break;
            }
            pointerNode = pointerNode.getNext();
        }
        pointerNode.setNext(stackNode);
    }

    //出栈操作
    public Integer pop(){
        StackNode pointerNode = headNode;
        StackNode tempNode = null;
        //判断栈是否为空
        if(isEmpty()){
            System.out.println("栈空！");
            return null;
        }
        while(true){
            if(pointerNode.getNext()==null){
                //找到栈顶
                break;
            }
            tempNode = pointerNode;
            pointerNode = pointerNode.getNext();
        }
        //tempNode 为栈顶的前一个节点
        if(tempNode!=null) {
            tempNode.setNext(null);
        }
        return pointerNode.getNum();
    }

}


class StackNode{
    private int num;
    private StackNode next;

    public StackNode(int num) {
        this.num = num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public StackNode getNext() {
        return next;
    }

    public void setNext(StackNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "StackNode{" +
                "num=" + num +
                '}';
    }
}