package hengsheng;

/**
 * @author zhangsy
 * @date 2020/9/13 22:42
 *
 * 先学习几个概念:质数又称素数。指在一个大于1的自然数中，除了1和此整数自身外，不能被其他自然数整除的数。
 * 把一个合数分解成若干个质因数的乘积的形式，叫做分解质因数。比如 12 可以分解成 2*2*3。
 *   请写一段程序，能够把从键盘输入的任意一个合数分解成质因数的乘积
 */
public class 质数分解 {

    public static void main(String[] args) {
        System.out.println(method(12549));
    }

    public static String method(int num){

        if(num < 2) return num + "";
        if(num == 2) return "1*2";
        StringBuilder sb = new StringBuilder();
        int index = 2 , temp = num;
        while (true){
            if(num==1 || index > temp - 1) break;
            if(num%index ==0){
                num /= index;
                sb.append(index);
                sb.append("*");
            }else {
                index++;
            }
        }
        return sb.toString().substring(0,sb.length() - 1);
    }
}
