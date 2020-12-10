package jiangzhi_offer;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

/**
 * @author zhangsy
 * @date 2020/9/21 23:00
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class 字符串的排列 {

    public static void main(String[] args) {
        字符串的排列 c = new 字符串的排列();
        System.out.println(c.Permutation("abc"));
    }

    private ArrayList<String> res = new ArrayList<>();
    private Deque<Character> deque = new LinkedList<>();

    public ArrayList<String> Permutation(String str) {
        if (str == null || str.length() == 0) return res;
        dfs(str, 0, res, deque);
        return res;
    }

    private void dfs(String str, int start, ArrayList<String> res, Deque<Character> deque) {
        if (deque.size() == str.length()) {
            StringBuilder sb = new StringBuilder();
            System.out.println(deque);
            for (Character character : deque) {
                sb.append(character);
            }
            res.add(sb.toString());
            return;
        }
        for (int i = start; i < str.length(); i++) {
            deque.add(str.charAt(start));
            dfs(str,start + 1, res, deque);
            deque.removeLast();
        }
    }
}
