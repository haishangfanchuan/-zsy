package leetcode.letcode100;

import java.util.*;

/**
 * @author zhangsy
 * @date 2020/9/12 23:47
 * <p>
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * <p>
 *  
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class 最长不含重复字符的子字符串 {

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbbq"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if("".equals(s) || s.length()==0) return 0;
        if(s.length() == 1) return 1;
        Map<Character, Character> map = new HashMap<>();
        int len = s.length(),l = 0, r = 1 , temp = 0,res = 0 , count = 0;
        for (int i = 0; i < len; i++) {
            char lc = s.charAt(l);
            char rc = s.charAt(r);
            if(!map.containsKey(rc) && lc!=rc){
                map.put(lc,lc);
                map.put(rc,rc);
                // r - l即为最大长度
                res = Math.max(temp,r - l + 1);
                r++;count++;
                if(r >= len) break;
            }else {
                //clear缓存
                if(!map.isEmpty())  map.clear();
                //保存上一次最大长度
                temp = res;
                l = r;
                r = l + 1;
                if(r >= len) break;
            }
        }

        return count > 0 ? res : 1;
    }
}
