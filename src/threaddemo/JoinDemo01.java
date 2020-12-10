package threaddemo;

/**
 * 多线程join的demo
 */
public class JoinDemo01 {

    public static void main(String[] args) throws InterruptedException {
        Thread threadA = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程："+Thread.currentThread()+"...正在执行");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadB = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程："+Thread.currentThread()+"...正在执行");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread threadC = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("线程："+Thread.currentThread()+"...正在执行");
                try {
                    Thread.sleep(8000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        long startTime = System.currentTimeMillis();
        threadA.start();
        threadA.join();
        threadB.start();
        threadB.join();
        threadC.start();
        threadC.join();
        long endTime = System.currentTimeMillis();
        System.out.println("共花费："+(endTime-startTime));
    }
}
