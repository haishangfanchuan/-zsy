package threaddemo.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class ReenTrantLockDemo01{
    private static int count = 0;

    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true);
        byte[] lock = new byte[1];
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    try {
                        reentrantLock.lock();
                        Thread.sleep(2000);
                        count++;
                    }catch (Exception e){
                        e.printStackTrace();
                    }finally {
                        reentrantLock.unlock();
                    }
                }

            }).start();
        }

        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(count);
    }
}
