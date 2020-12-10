package leetcode.letcode100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/15 14:06
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 */
public class 第k个排列 {

    public static void main(String[] args) {
        第k个排列 c = new 第k个排列();
        System.out.println(c.getPermutation(3,3));
    }

    public String getPermutation(int n, int k) {
        if(n <=0 || k <0) return " ";
        int count = nFactorial(n);
        if(k > count) return " ";
        if(n == 1) return n+"";

        List<List<Character>> parentList = new ArrayList<>();
        Deque<Character> deque = new LinkedList<>();
        //定位开始查找的数字，减少递归次数
        int nCount = nFactorial(n - 1);
        int start = k / nCount + 1;
        //防止start越界
        start = start > n ? start -1 : start;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n ; i++) {
            sb.append(i);
        }
        dfs(parentList,deque,sb.toString(),n,0);
        System.out.println(parentList);
        return parentList.get(k - 2).toString();
    }

    private void dfs(List<List<Character>> list , Deque<Character> deque , String nStr , int n,int start){
        if(deque.size() == n) {
            list.add(new ArrayList<>(deque));
            return;
        }

        for (int i = start; i < nStr.length(); i++) {
            deque.add(nStr.charAt(start));
            dfs(list,deque,nStr,n,start + 1);
            deque.removeLast();
        }
    }

    private int nFactorial(int n ){
        int res = 1;
        for (int i = 1; i <=n ; i++) {
            res *= i;
        }
        return res;
    }
}
