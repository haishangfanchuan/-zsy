package niucode;

/**
 * @author shengyun
 * @date 2021/1/6
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，
 * 但是与"aa.a"和"ab*a"均不匹配
 * 示例1
 * 输入
 * "aaa","a*a"
 * 返回值
 * true
 */
public class 正则表达式匹配 {

    public static void main(String[] args) {
        System.out.println(match("".toCharArray(),".*".toCharArray()));
    }

    public static boolean match(char[] str, char[] pattern) {
        if (str.length == 0 && pattern.length == 0) return true;
        //abcdefg abc*de*
        int s = 0, p = 0;
        while (s < str.length && p < pattern.length) {
            if (str[s] == pattern[p] || pattern[p] == '.') {
                s++;
                p++;
                if (s == str.length - 1 && (p < pattern.length - 1 || p >= pattern.length)) return false;
                if (s == str.length - 1 && p == pattern.length - 1) return true;
            }else if (pattern[p] == '*') {
                p++;
                if (p == pattern.length) return true;
                while (str[s] != pattern[p]) {
                    s++;
                }
            }else {
                return false;
            }
        }
        return false;
    }
}
