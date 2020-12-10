package leetcode.letcode100;



import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/7 12:53
 *
 * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

    示例：

    输入：n = 3
    输出：[
    "((()))",
    "(()())",
    "(())()",
    "()(())",
    "()()()"
    ]
 */
public class 括号生成 {
    public List<String> generateParenthesis(int n) {

        List<String> res = new ArrayList<>();
        // 特判
        if (n == 0) {
            return res;
        }
        generate(res,"",0,0,n);
        return res;
    }



    /**
     *
     * @param list  返回集合
     * @param string 需要判断的字符串
     * @param a      记录"("数量
     * @param b      记录")"数量
     */
    private void generate(List<String> list , String string , int a, int b, int n){
        if(a>n || b > n) return;
        if(a==n && b==n) list.add(string);

        if(a>=b){
            String s = string;
            generate(list,string+"(",a+1,b,n);
            generate(list,s+")",a,b+1,n);
        }
    }
}
