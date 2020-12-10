package leetcode.letcode100;

import com.sun.org.apache.xerces.internal.xs.StringList;
import com.sun.xml.internal.ws.util.StringUtils;

import java.util.*;

/**
 * @author zhangsy
 * @date 2020/9/12 15:00
 * <p>
 * <p>
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * <p>
 * 示例:
 * <p>
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 */
public class 字母异位词分组 {

    public static void main(String[] args) {
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        if (strs == null || strs.length == 0)
            return new ArrayList<>();
        for (String string : strs) {
            //将string转化位字符数组->去重->比较是否是异位字符串
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if(!map.containsKey(key))
                map.put(key,new ArrayList<>());
            map.get(key).add(string);
        }
        return new ArrayList<>(map.values());
    }
}
