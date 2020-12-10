package jiangzhi_offer;

import com.sun.javafx.binding.StringFormatter;

/**
 * @author zhangsy
 * @date 2020/9/28 1:21
 * <p>
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 输出描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * +2147483647
 * 1a33
 *
 * 输出
 * 2147483647
 * 0
 */
public class 把字符串转为整数 {

    public static void main(String[] args) {
        System.out.println(StrToInt("214748364855"));
    }

    public static int StrToInt(String str) {
        if(str.equals("0") || str.length()==0) return 0;
        char firstChar = str.charAt(0);
        int res = 0  , end = 0 ,num = 1 ,len = str.length() , max = Integer.MAX_VALUE;
        boolean flag = true;
        if(firstChar == '-') {
            flag = false;
            end = 1;
        }else if(firstChar == '+') {
            end = 1;
        }
        //1002536
        for (int i = len - 1; i >= end; i--) {
            int tempNum = str.charAt(i) - '0';
            res +=  num * tempNum;
            if(num*10 > max) return 0;
            num*=10;

        }

        return flag ? res : -res;
    }
}
