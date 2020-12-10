package leetcode.letcode100;

import java.util.*;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
 示例 1：
 输入: "babad"
       dabab
 输出: "bab"
 注意: "aba" 也是一个有效答案。
 示例 2：
 输入: "cbbd"
 输出: "bb"
 */
public class 最长回文子串 {

    public static void main(String[] args) {
        System.out.println("bacd".indexOf("a"));
        System.out.println("bcad".substring(1,4));
        System.out.println(longestPalindrome("abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababa"));
    }

    public static String longestPalindrome(String s) {
        if(s.length()==1){
            return s;
        }
        char[] chars = s.toCharArray();
        String corStr = reversalStr(s);
        String targetStr = "";
        String substring = null;
        for (int i = 0; i < chars.length; i++) {
            for (int j = i; j < chars.length; j++) {
                if(chars[i]==chars[j]){
                    substring = s.substring(i, j + 1);
                    if(corStr.contains(substring) && substring.equals(reversalStr(substring))){
                        targetStr = targetStr.length()>substring.length()? targetStr:substring;
                    }
                }
            }
        }
        return targetStr;
    }

    private static String reversalStr(String str){
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = chars.length-1; i >= 0; i--) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }
}
