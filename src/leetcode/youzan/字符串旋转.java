package leetcode.youzan;

/**
 * pu'b:
 给定两字符串A和B，如果能将A从中间某个位置分割为左右两部分字符串（都不为空串），
 并将左边的字符串移动到右边字符串后面组成新的字符串可以变为字符串B时返回true。
 例如：如果A=‘youzan’，B=‘zanyou’，A按‘you’‘zan’切割换位后得到‘zanyou’和B相同返回true。

 输入描述:
 2个不为空的字符串(说明:输入一个字符串以英文分号";"分割为2个字符串)
 例如:youzan;zanyou 即为A=‘youzan’，B=‘zanyou’

 输出描述:
 输出true或false(表示是否能按要求匹配两个字符串)

 输入例子1:
 youzan;zanyou

 输出例子1:
 true

 输入例子2:
 youzan;zyouan

 输出例子2:
 false
 */
public class 字符串旋转 {

    public static void main(String[] args) {

    }

    public boolean rotateString(String A, String B) {
        if(A==null || A.equals("") || B==null || B.equals("")){
            return false;
        }
        char[] charsA = A.toCharArray();
        char[] charsB = B.toCharArray();
        //找到B字符串的第一个字符
        int index = 0;
        char startB = charsB[0];
        for (int i = 0; i < charsA.length; i++) {
            if(charsA[0]==startB){
                return false;
            }
            if(charsA[i]==startB){
                index = i;
                break;
            }
        }
        String substringF = A.substring(0, index-1);
        String substringL = A.substring(index, A.length()-1);
        return (substringL+substringF).equals(B);
    }
}
