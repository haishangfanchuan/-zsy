package jiangzhi_offer;

/**
 * @author zhangsy
 * @date 2020/9/17 13:07
 */
public class 斐波那契數列 {

    public int Fibonacci(int n) {
        if(n == 1 || n == 2) return 1;
        int pre1 = 1,pre2 =1,res = 0;
        for (int i = 3; i <=n ; i++) {
            res = pre1 + pre2;
            pre1 = pre2;
            pre2 = res;
        }

        return res;
    }
}
