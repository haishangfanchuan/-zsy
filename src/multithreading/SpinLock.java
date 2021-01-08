package multithreading;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengyun
 * @date 2020/12/29
 */
public class SpinLock {

    private AtomicReference<Thread> ref = new AtomicReference<>();

    private static int state = 0, temp = 1;

    public void lock() {
        Thread currentThread = Thread.currentThread();
        while (ref.compareAndSet(null,currentThread)) {
            System.out.println(currentThread.getName() + " >>> 获取到了锁");
        }
    }

    public void unlock() {
        ref.compareAndSet(Thread.currentThread(),null);
    }


    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition[] conditions = {lock.newCondition(),lock.newCondition()};
        Runnable runnable = () -> {
            try {
                lock.lock();
                int name = Integer.parseInt(Thread.currentThread().getName());
//                System.out.println(name);
                while (temp < 100) {
                    while (state != name - 1) {
                        conditions[name - 1].await();
                    }
                    System.out.println(name + " >>>>>>>> " + temp++);
                    state = name % 2;
                    conditions[state].signal();//唤醒上一个线程
                    conditions[name - 1].await();//阻塞当前线程
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }

        };
        new Thread(runnable,"1").start();
        new Thread(runnable,"2").start();
    }
}

