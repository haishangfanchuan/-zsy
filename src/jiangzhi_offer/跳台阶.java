package jiangzhi_offer;

/**
 * @author zhangsy
 * @date 2020/9/17 13:14
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 */
public class 跳台阶 {

    public static void main(String[] args) {
        System.out.println(JumpFloor(3));
    }

    public static int JumpFloor(int target) {
        if (target == 1) return 1;
        if (target == 2) return 2;

        int pre = 1, pre2 = 2, res = 0;
        for (int i = 3; i <= target ; i++) {
            res = pre + pre2;
            pre = pre2;
            pre2 = res;
        }
        return res;
    }
}
