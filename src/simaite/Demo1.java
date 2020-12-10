package simaite;

import java.util.*;

/**
 * @author zhangsy
 * @date 2020/9/30 19:32
 */
public class Demo1 {

    public static void main(String[] args) {
        Demo1 d = new Demo1();
        System.out.println(d.method("WHL"));
    }

    private List<String> res = new ArrayList<>();
    private Deque<Character> deque = new LinkedList<>();
    public List<String> method (String string) {
        char[] chars = string.toCharArray();
        Arrays.sort(chars);
        fun(chars,0,res,deque);
        return res;
    }

    public void fun(char[] chars,int start,List<String> res,Deque<Character> deque){
        if(deque.size() == chars.length){
            StringBuilder sb = new StringBuilder();
            for (Character c : deque) {
                sb.append(c);
            }
            res.add(sb.toString());
            return;
        }

        for (int i = start; i < chars.length; i++) {
            deque.add(chars[i]);
            fun(chars,start + 1,res,deque);
            deque.removeLast();
        }
    }
}
