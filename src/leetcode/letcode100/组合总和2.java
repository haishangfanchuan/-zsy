package leetcode.letcode100;

import java.util.*;

/**
 * @author zhangsy
 * @date 2020/9/10 20:28
 * <p>
 * 给定一个数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用一次。
 * <p>
 * 说明：
 * <p>
 * 所有数字（包括目标数）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1:
 * <p>
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 所求解集为:
 * [
 * [1, 7],
 * [1, 2, 5],
 * [2, 6],
 * [1, 1, 6]
 * ]
 * 示例 2:
 * <p>
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 所求解集为:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
public class 组合总和2 {

    public static void main(String[] args) {
        组合总和2 c = new 组合总和2();
        int[] array = {2,5,2,1,2};
        Arrays.sort(array);
        System.out.println(c.combinationSum2(array,5));
    }

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0 || target < 0) return res;
        Arrays.sort(candidates);
        combination(candidates, target, 0, list, res);

        return res;
    }

    private void combination(int[] candidates, int target, int start, Deque<Integer> deque, List<List<Integer>> lists) {
        if (target<0) return;
        if (target == 0) {
            lists.add(new ArrayList<>(deque));
            return;
        }

        //1,2,2,2,5
        for (int i = start; i < candidates.length; i++) {
            if(i > start && candidates[i]==candidates[i-1]) continue;

            deque.add(candidates[i]);
            combination(candidates, target - candidates[i], i+1, deque, lists);
            deque.removeLast();
        }
    }
}
