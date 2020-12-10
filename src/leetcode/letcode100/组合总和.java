package leetcode.letcode100;

/**
 * @author zhangsy
 * @date 2020/9/9 12:51
 */

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。 
 * 示例 1：
 * <p>
 * 输入：candidates = [2,3,6,7], target = 7,
 * 所求解集为：
 * [
 * [7],
 * [2,2,3]
 * ]
 * 示例 2：
 * <p>
 * 输入：candidates = [2,3,5], target = 8,
 * 所求解集为：
 * [
 *   [2,2,2,2],
 *   [2,3,3],
 *   [3,5]
 * ]
 */
public class 组合总和 {

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> list = new LinkedList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {

        if (target < 0 || candidates.length == 0) return res;
        combinationSum(candidates, target, 0, candidates.length, res, list);
        return res;

    }

    private void combinationSum(int[] candidates, int target, int start, int end, List<List<Integer>> res, Deque<Integer> list) {

        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < end; i++) {
            list.add(candidates[i]);
            combinationSum(candidates, target - candidates[i], i, end, res, list);
            list.removeLast();
        }
    }
}
