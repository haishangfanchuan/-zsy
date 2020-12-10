package leetcode.letcode100;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 示例:
 输入："23"
 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */
public class 电话号码的字母组合 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("2379"));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if("".equals(digits) || digits == null){
            return list;
        }
        List<String> strings = digitsToAbc(digits);
        System.out.println(strings);
        String firstStr = strings.get(0);
        for (int i = 0; i < firstStr.length(); i++) {
            int index = 0;
            String ans = String.valueOf(firstStr.charAt(i));
            for (int j = 1; j < strings.size(); j++) {
                while (index < strings.get(j).length()) {
                    ans+=strings.get(j).charAt(index);
                    index++;
                    list.add(ans);
                    ans = String.valueOf(firstStr.charAt(i));
                }
            }
        }
        return list;
    }

    //根据输入数字获取字母的list
    private static List<String> digitsToAbc(String digits){
        Map<String, String> map = new HashMap<>();
        map.put("2","abc");
        map.put("3","def");
        map.put("4","ghi");
        map.put("5","jkl");
        map.put("6","mno");
        map.put("7","pqrs");
        map.put("8","tuv");
        map.put("9","wxyz");
        List<String> strings = new ArrayList<>();
        for (int i = 0; i < digits.length(); i++) {
            String str = map.get(String.valueOf(digits.charAt(i)));
            strings.add(str);
        }
        return strings;
    }
}
