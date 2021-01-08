package niucode;

/**
 * @author shengyun
 * @date 2021/1/6
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 示例1
 * 输入
 * "123.45e+6"
 * 返回值
 * 复制
 * true
 *
 * 示例2
 * 输入
 * "1.2.3"
 * 返回值
 * 复制
 * false
 *
 */
public class 表示数值的字符串 {

    public static void main(String[] args) {
        String s = "+100";
        char[] chars = s.toCharArray();
        System.out.println(isNumeric(chars));
    }

    public static boolean isNumeric(char[] str) {

        try {
            StringBuilder numL = new StringBuilder();
            StringBuilder numR = new StringBuilder();
            boolean flag = true;
            for (char c : str) {
                if (c == 'e' || c == 'E') {
                    flag = false;
                    continue;
                }
                if (flag) numL.append(c);
                else numR.append(c);
            }
            String strL = numL.toString();
            String strR = numR.toString();
            if ((strL.length() == 0 || strR.length() == 0) && !flag) return false;
            if (strL.length() != 0) Double.valueOf(strL);
            if (strR.length() != 0) Long.valueOf(strR);
        }catch (Exception e) {
            return false;
        }
        return true;
    }
}
