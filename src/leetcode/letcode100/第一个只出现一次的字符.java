package leetcode.letcode100;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangsy
 * @date 2020/9/12 23:19
 * <p>
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * <p>
 * 示例:
 * <p>
 * s = "abaccdeff"
 * 返回 "b"
 * <p>
 * s = ""
 * 返回 " "
 */
public class 第一个只出现一次的字符 {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("leetcodecd"));
    }

    public static char firstUniqChar(String s) {
        if("".equals(s)) return ' ';
        if(s.length()==1) return s.charAt(0);
//        Map<Character, Character> map = new HashMap<>();
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if(map.containsKey(c) || s.substring(i+1).contains(c+"")) {
//                map.put(c, c);
//                continue;
//            }
//            return c;
//        }
//        return ' ';


        char[] chars = s.toCharArray();
        //对chars进行排序，采用双指针
        Arrays.sort(chars);
        System.out.println(Arrays.toString(chars));
        int l = 0,r = 1, len = chars.length;
        while (true){
            //如果前一个字符和后一个字符一样，continue;
            // l = r + 1; r = l + 1;
            if(r < len && chars[l]==chars[r]){
                l = r + 1;
                r = l + 1;
            }else if(l >= len - 1){
                return chars[l];
            }else return chars[l];
        }
    }
}
