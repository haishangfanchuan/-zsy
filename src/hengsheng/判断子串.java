package hengsheng;

/**
 * @author zhangsy
 * @date 2020/9/14 0:41
 * 编写一个函数，输入参数为三个：主字符串，子字符串，分隔符(例如：主字符串:1,bv,443s,9s9s
 * 子字符串：9s9s  分隔符: ，)。要求在不用类似strstr(Java中的substring函数)，
 * strtok(Java中的StringToken类)等函数的前提下(遍历字符串来实现)，实现判断子串在住串的存在性。
 */
public class 判断子串 {

    public static void main(String[] args) {
        System.out.println(subStrinExit("1,bv,443s,9s9s","9s9s"));
    }

    public static boolean subStrinExit(String str1, String str2) {
        if (str1 == null || str2 == null) return false;
        if (str1.equals(str2)) return true;
        if (str2.length() == 1) return str1.contains(str2.charAt(0) + "");
        int l = 0;
        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(l)) {
                l=0;
                continue;
            }
            if (str1.charAt(i) == str2.charAt(l)) {
                l++;
            }
            if (l == str2.length()) return true;
        }
        return false;
    }
}
