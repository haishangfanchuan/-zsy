package multithreading;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengyun
 * @date 2020/12/23
 *
 * 线程交叉打印数字
 */
public class Demo01 {
    public static void main(String[] args) throws InterruptedException {

        Class<PrintNumber> aClass = PrintNumber.class;

        PrintNumber number = new PrintNumber();
        Thread a = new Thread(number, "A");
        a.start();
        Thread b = new Thread(number, "B");
        b.start();
        Thread c = new Thread(number, "C");
        c.start();
    }
}


class PrintNumber implements Runnable {

    private ReentrantLock lock = new ReentrantLock();
    private int max;
    private int threadNum;
    private volatile int start;
    Condition condition;
    public PrintNumber(int start,int max,int threadNum) {
        this.start = start;
        this.max = max;
        this.threadNum = threadNum;
        condition = lock.newCondition();
    }

    public PrintNumber() {
    }

    @Override
    public void run() {
        try {
            lock.lock();
            condition.signalAll();
            while (start < max) {
                System.out.println("当前线程 >>>> " + Thread.currentThread().getName() + " >>>> " + start++);
                condition.await();
            }
            condition.signalAll();
        }catch (InterruptedException e){
            e.printStackTrace();
        } finally{
            lock.unlock();
        }

    }
}

class ReentrantLockCondition {
    private static Lock lock = new ReentrantLock();
    private static Condition[] conditions = {lock.newCondition(), lock.newCondition(), lock.newCondition()};
    private volatile int state = 1;
    private final AtomicInteger atomicInteger = new AtomicInteger(1);

    private void handle(int state) {

        lock.lock();
        try {
            while(atomicInteger.get() < 100) {
                while(this.state != state) {
                    conditions[state - 1].await();
                }
                System.out.println("当前线程: "+Thread.currentThread().getName() + " >>> " + atomicInteger.incrementAndGet());
                this.state = state % 3 + 1;
                conditions[this.state - 1].signal();//唤醒上一个进程
                conditions[state - 1].await();//阻塞当前进程
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        ReentrantLockCondition rlc = new ReentrantLockCondition();
        new Thread(()->rlc.handle(1),"A").start();
        new Thread(()->rlc.handle(2),"B").start();
        new Thread(()->rlc.handle(3),"C").start();
    }
}
