package leetcode.letcode100;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author zhangsy
 * @date 2020/9/6 21:52
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。

    有效字符串需满足：

    左括号必须用相同类型的右括号闭合。
    左括号必须以正确的顺序闭合。
    注意空字符串可被认为是有效字符串。

    示例 1:

    输入: "()"
    输出: true
    示例 2:

    输入: "()[]{}"
    输出: true
    示例 3:

    输入: "(]"
    输出: false
    示例 4:

    输入: "([)]"
    输出: false
    示例 5:

    输入: "{[]}"
    输出: true

 */
public class 有效的括号 {
    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }

    public static boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put('(',')');
        map.put('[',']');
        map.put('{','}');
        s = s.trim();
        if(s.equals("") || s.length()%2!=0 || !map.containsKey(s.charAt(0))) return false;
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if(chars[i]=='(' || chars[i]=='[' || chars[i]=='{') stack.push(chars[i]);
            else if (stack.isEmpty() || chars[i]!=map.get(stack.pop())) return false;

        }
        return stack.isEmpty();
    }
}
