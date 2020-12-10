package leetcode.letcode100;

import java.util.*;

/**
 * @author zhangsy
 * @date 2020/9/11 20:17
 * <p>
 * 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * <p>
 * 示例:
 * <p>
 * 输入: [1,1,2]
 * 输出:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */
public class 全排列2 {

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> deque = new LinkedList<>();
    private Set<List> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {

        if (nums.length == 0) return res;
        int[] isVisited = new int[nums.length];
        permute(nums ,res,deque,isVisited);
        return res;

    }

    private void permute(int[] nums ,List<List<Integer>> res, Deque<Integer> deque,int[] isVisited) {

        if (deque.size() == nums.length) {
            List<Integer> arrayList = new ArrayList<>(deque);
            if(!set.contains(arrayList))
                res.add(arrayList);
            set.add(arrayList);
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if(isVisited[i] == 1) continue;
            deque.add(nums[i]);
            isVisited[i] = 1;
            permute(nums ,res,deque,isVisited);
            isVisited[i] = 0;
            deque.removeLast();
        }
    }

    public static void main(String[] args) {
        全排列2 c = new 全排列2();
        int[] array = {1, 1, 2};
        System.out.println(c.permuteUnique(array));
    }
}
