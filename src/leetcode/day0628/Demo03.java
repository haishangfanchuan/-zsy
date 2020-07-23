package leetcode.day0628;

public class Demo03 {
    private int count = 0;
    private final Object lock1 = new Object();
    private final Object lock2 = new Object();
    private final Object lock3 = new Object();

    public static void main(String[] args) throws InterruptedException {
//        new MultiTurningThread().multiTurning();
    }

    public void multiTurning() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock2) {
                    synchronized (lock1) {
                        System.out.println("线程1: 1");
                        count++;
                        // 唤醒正等待 lock1 的 t3
                        lock1.notifyAll();
                    }
                    try {
                        // 如果还需要继续执行，则让出 lock2 让 t2 执行，自己进入等待状态
                        if (count <= 100) {
                            lock2.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t2 = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock3) {
                    synchronized (lock2) {
                        System.out.println("线程2: 2");
                        count++;
                        // 唤醒正在等待 lock2 的 t1
                        lock2.notifyAll();
                    }
                    try {
                        // 如果还需要继续执行，则让出 lock3 让 t3 执行，自己进入等待状态
                        if (count <= 100) {
                            lock3.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        Thread t3 = new Thread(() -> {
            while (count <= 100) {
                synchronized (lock1) {
                    synchronized (lock3) {
                        System.out.println("线程3: 3");
                        count++;
                        // 唤醒正在等待 lock3 的 t2
                        lock3.notifyAll();
                    }
                    try {
                        // 如果还需要继续执行，则让出 lock1 让 t1 执行，自己进入等待状态
                        if (count <= 100) {
                            lock1.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t1.start();
        t2.start();
        t3.start();
    }


}

