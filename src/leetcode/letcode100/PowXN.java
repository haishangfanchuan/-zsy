package leetcode.letcode100;

/**
 * @author zhangsy
 * @date 2020/9/12 16:10
 * <p>
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 * <p>
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 * <p>
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 */
public class PowXN {

    public static void main(String[] args) {
        System.out.println(myPow(2.00000,
                10));
    }

    public static double myPow(double x, int n) {
        if (n == 0) return 1d;
        if (n == 1 || x == 1d || x == 0) return x;
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        double temp = 1d;
        System.out.println(N);
        while (N > 0) {
            //判断二进制的n最后一位是否为1
            if ((N & 1) == 1) temp *= x;
            //x = x^2 ==> n右移动一位
            x*=x;
            N >>=1;
        }
        return temp;
    }
}
