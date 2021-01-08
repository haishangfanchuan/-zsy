package niucode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author shengyun
 * @date 2020/12/29
 *
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 示例1
 * 输入
 * "ab"
 * 返回值
 * ["ab","ba"]
 */
public class 字符串的排列 {

    public static void main(String[] args) {
        字符串的排列 c = new 字符串的排列();
        System.out.println(c.Permutation("ABC"));
    }

    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() ==0) return list;
        char[] chars = str.toCharArray();
        int[] flags = new int[str.length()];
        permutation(str.length(),chars,new ArrayDeque<>(),list,flags);
        return list;
    }

    private void permutation(int len,char[] chars,Deque<Character> deque,ArrayList<String> list, int[] flags) {
        if (chars.length == 0) return;
        if (deque.size() == len) {
            list.add(String.valueOf(deque));
            return;
        }
        for (int i = 0; i < chars.length; i++) {
            if (flags[i] == 1) continue;
            deque.add(chars[i]);
            flags[i] = 1;
            permutation(len,chars,deque,list,flags);
            flags[i] = 0;
            deque.removeLast();
        }
    }
}
