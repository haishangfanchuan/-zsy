package leetcode.letcode100;

/**
 * @author zhangsy
 * @version 1.0
 * @description
 * @date 2020/9/4 19:05
 */
public class 打印质数 {

    public static void main(String[] args) {
        printZhishu(1000);
    }

    private static void printZhishu(int n) {
        if (n < 2) {
            System.out.print("不存在质数");
        }
        System.out.print(2 + " ");
        boolean flag = true;
        for (int i = 3; i < n; i += 2) {
            if (i % 2 == 0) continue;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    flag = false;
                    break;
                }
            }
            if (flag) System.out.print(i + " ");
            flag = true;
        }
    }
}
