package niucode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author shengyun
 * @date 2020/12/30
 *
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置,
 * 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 示例1
 * 输入
 * "google"
 * 返回值
 * 4
 */
public class 第一个只出现一次的字符位置 {

    public static void main(String[] args) {
        System.out.println(FirstNotRepeatingChar("google"));
    }

    public static int FirstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return -1;
        Map<Character, Integer> map = new HashMap<>();
        int ans = 0, temp = Integer.MAX_VALUE, max = 0, preMax = 0;
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i),-1);
                continue;
            }
            map.put(str.charAt(i),temp);
            temp--;
        }
        //找到最大的value对应的key
        char c = str.charAt(0);
        for (Map.Entry<Character,Integer> entry : map.entrySet()) {
            preMax = ans;
            ans = Math.max(entry.getValue(),ans);
            if (preMax != ans) c = entry.getKey();
        }
        return str.indexOf(c);
    }
}
