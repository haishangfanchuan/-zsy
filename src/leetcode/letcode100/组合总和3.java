package leetcode.letcode100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/11 12:06
 * <p>
 * 找出所有相加之和为 n 的 k 个数的组合。组合中只允许含有 1 - 9 的正整数，并且每种组合中不存在重复的数字。
 * <p>
 * 说明：
 * <p>
 * 所有数字都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: k = 3, n = 7
 * 输出: [[1,2,4]]
 * 示例 2:
 * <p>
 * 输入: k = 3, n = 9
 * 输出: [[1,2,6], [1,3,5], [2,3,4]]
 */
public class 组合总和3 {

    public static void main(String[] args) {
        组合总和3 c = new 组合总和3();
        System.out.println(c.combinationSum3(3, 7));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> deque = new LinkedList<>();

    public List<List<Integer>> combinationSum3(int k, int n) {
        if (k < 0 || n < 0) return res;
        combination(k, n,1, deque, res);
        return res;

    }

    private void combination(int k, int n,int index, Deque<Integer> deque, List<List<Integer>> lists) {
        if (k < 0 || n < 0) return;
        if (k==0 && n == 0) {
            lists.add(new ArrayList<>(deque));
            return;
        }
        for (int i = index; i < 10; i++) {
            deque.add(i);
            combination(k -1, n - i, i + 1 ,deque, lists);
            deque.removeLast();
        }
    }
}
