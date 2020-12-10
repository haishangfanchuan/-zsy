package daxi;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/14 20:10
 * <p>
 * 给定⼀个⾮空字符串 s 和⼀个缩写 abbr，请校验它们是否匹配。
 * 假设字符串中只包含⼩写字⺟，缩写中只包含⼩写字⺟和数字。缩写中的数字
 * 表示其缩略的字符数；连续多位数字表示⼀个多位数。
 * 例如，字符串 “word” 的缩写有且仅有以下这些：[“word", "1ord", "w1rd",
 * "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d",
 * "w3", “4"]。
 *
 * 例 1：输⼊：s = “internationalization"，abbr = "i12iz4n"
 * 返回：true
 * 解释：abbr 中的 12 表示有⼗⼆个字符被缩略了。
 *
 * 例 2：输⼊：s = “apple"，abbr = “a2e"
 * 返回：false
 * 需要实现的⽅法原型：boolean valid(String word, String abbr)
 */


public class 缩写校验 {

    public static void main(String[] args) {


        System.out.println(valid("internationalization","i12iz4n"));
    }

    public static boolean valid(String word, String abbr){
        if(word==null || abbr==null || abbr.length()==0
                ||abbr.length() > word.length()) return false;
        //abbr是数字的特殊情况
        if(abbr.length()==1) {
            return abbr.charAt(0) - '0' == word.length();
        }
        if(word.equals(abbr)) return true;

        List<Character> list = Arrays.asList('1', '2', '3', '4', '5', '6', '7', '8', '9');
        int w = 0 , a = 0;
        if(list.contains(abbr.charAt(a)) && word.charAt(w)!=abbr.charAt(a)){//既不是数字，第一个字符也不相等
            return false;
        }
        while (a < abbr.length()){
            //判断abbr a 小标是否为数字  是的话就找出这个数字
            StringBuilder sb = new StringBuilder();
            while (list.contains(abbr.charAt(a))){
                sb.append(abbr.charAt(a));
                a++;
            }
            if(!sb.toString().equals("")) {
                int anInt = Integer.parseInt(sb.toString());
                if (word.indexOf(anInt + w) != abbr.indexOf(a)) {
                    return false;
                }else {
                    w += anInt;
                }
            }
            if(word.charAt(w)==abbr.charAt(a)){
                w++;a++;
            }else return false;
        }
        return true;
    }
}
