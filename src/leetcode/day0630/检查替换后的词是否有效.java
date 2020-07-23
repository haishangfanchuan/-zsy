package leetcode.day0630;

/**
 *给定有效字符串 "abc"。
 对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。
 （X 或 Y 可以为空。）那么，X + "abc" + Y 也同样是有效的。
 例如，如果 ShellSort = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。
 无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
 如果给定字符串 ShellSort 有效，则返回 true；否则，返回 false。

 */

public class 检查替换后的词是否有效 {

    public static void main(String[] args) {
        检查替换后的词是否有效 s = new 检查替换后的词是否有效();
        System.out.println(s.isValid("ababcabcc"));
    }
        boolean isValid(String S) {
        if(S.equals("abc")){
            return true;
        }
        char[] chars = S.toCharArray();
        if(S.contains("abc")){
            int a = S.indexOf("a");
            for (int i = a; i <S.length() ; i++) {
                if(chars[i]=='a'){
                    if(i+3<S.length()&&chars[i+1]=='b'&&chars[i+2]=='c'){
                        StringBuilder stringBuffer = new StringBuilder();
                        for (int j = 0; j <i ; j++) {
                            stringBuffer.append(chars[j]);
                        }
                        for (int j = i+3; j <S.length() ; j++) {
                            stringBuffer.append(chars[j]);
                        }
                        for (int j = 0; j <stringBuffer.length() ; j+=3) {
                            if(j+2<stringBuffer.length()&&stringBuffer.charAt(j)=='a'&&stringBuffer.charAt(j+1)=='b'&&stringBuffer.charAt(j+2)=='c'){
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }
}
