package multithreading;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengyun
 * @date 2020/12/22
 */
public class BankDemo {

    public static void main(String[] args) {
        Bank bank = new Bank();
        for (int i = 0; i < 100; i++) {
            int from = i;
            new Thread(() -> {
                int to = (int) (Math.random() * Bank.BANK_SIZE);
                int money = (int) (Math.random() * Bank.money);
                bank.transfer(1,to,money);
                System.out.println();
            }).start();
        }
    }

}

class Bank {
    private static  int[] accounts;
    public static final int BANK_SIZE = 100;
    public static final int money = 1000;
    private ReentrantLock lock = new ReentrantLock();
    Condition noMoneyCondition;
    public Bank() {
        accounts = new int[BANK_SIZE];
        Arrays.fill(accounts,money);
        //创建lock相关条件对象(账户余额不足时)
        noMoneyCondition = lock.newCondition();
    }

    public void transfer(int from ,int to,int money){
        try {
            lock.lock();
            System.out.print("当前线程: " + Thread.currentThread() + " ... ");
            while (accounts[from] < money) {
                System.out.println("当前账户余额不足...请稍后再试");
                noMoneyCondition.await();
            }
            accounts[from] -= money;
            accounts[to] += money;
            System.out.printf("账户A: %s --> 账户B: %s 转账: %s    当前银行总额: %s ",from,to,money,countMoney());
            noMoneyCondition.signalAll();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    private int countMoney(){
        int count = 0;
        for (int account : accounts) count += account;
        return count;
    }
}
