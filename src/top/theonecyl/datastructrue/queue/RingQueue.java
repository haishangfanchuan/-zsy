package top.theonecyl.datastructrue.queue;

import java.security.InvalidParameterException;

/**
 * @author zhangsy
 * @date 2020/9/15 20:16
 * 循环队列
 */
public class RingQueue {
    private static final int defaultSize = 10;
    public int size;
    private static Object[] o = null;

    private static int head = 0;
    private static int tail = 0;

    //队列大小
    private static int count = 0;

    public RingQueue() {
        o = new Object[defaultSize];
    }

    public RingQueue(int size) {
        if(size < 0) throw new InvalidParameterException("初始化大小不能为负数");
        this.size = size;
        o = new Object[size];
    }

    //添加元素
    public void addToRingQueue(Object object) {
        if (o == null) throw new NullPointerException("添加元素为空");
        if (size == 0) count = defaultSize;
        else count = size;
        //判断是否可以添加元素
        if(getSize() <= count){
            o[tail%count] = object;
            tail++;
        }else {
            throw new StackOverflowError("队列已满");
        }
    }

    //pop元素
    public Object pop(){
        //判断队列是否为空
        if(isEmpty()) throw new RuntimeException("队列为空");
        Object o = RingQueue.o[head];
        head++;
        return o;

    }

    //判断队列是否为空
    public boolean isEmpty() {
        return tail == head;
    }

    //获取队列大小
    public int getSize(){
        return tail - head;
    }

    public static void main(String[] args) {
        RingQueue queue = new RingQueue();
        for (int i = 1; i <= 10; i++) {
            queue.addToRingQueue(i);
        }
        for (int i = 1; i <= 10; i++) {
            System.out.println(queue.pop());
        }
        for (int i = 1; i <= 10; i++) {
            queue.addToRingQueue(i);
        }
        System.out.println(queue.getSize());
    }
}
