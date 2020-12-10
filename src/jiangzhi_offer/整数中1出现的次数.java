package jiangzhi_offer;

import java.util.concurrent.*;

/**
 * @author zhangsy
 * @date 2020/9/22 1:17
 * 求出1~13的整数中1出现的次数,并算出100~1300的整数中1出现的次数？
 * 为此他特别数了一下1~13中包含1的数字有1、10、11、12、13因此共出现6次,
 * 但是对于后面问题他就没辙了。ACMer希望你们帮帮他,并把问题更加普遍化,
 * 可以很快的求出任意非负整数区间中1出现的次数（从1 到 n 中1出现的次数）。
 */
public class 整数中1出现的次数 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(NumberOf1Between1AndN_Solution(55));
    }
    public static int NumberOf1Between1AndN_Solution(int n) {
        int count = 1 , temp = 1;
        for (int i = 10; i <= n; i++) {
            while (true) {
                if (i % temp ==0) {
                    temp*=10;
                    count++;
                }else {
                    temp = 10;
                    break;
                }
            }
        }
        return count;
    }
}
