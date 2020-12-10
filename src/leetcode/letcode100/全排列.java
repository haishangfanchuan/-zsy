package leetcode.letcode100;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/10 22:19
 *
 * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:

输入: [1,2,3]
输出:
[
[1,2,3],
[1,3,2],
[2,1,3],
[2,3,1],
[3,1,2],
[3,2,1]
]

 */
public class 全排列 {

    private List<List<Integer>> res = new ArrayList<>();
    private Deque<Integer> deque = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        if(nums==null || nums.length==0) return res;
        int[] ints = new int[nums.length];
        permute(nums,res,deque,ints);
        return res;
    }

    private void permute(int[] nums,List<List<Integer>> lists,Deque<Integer> deque,int[] ints){

        if(deque.size()==nums.length){
            lists.add(new ArrayList<>(deque));
            return;
        }

        for (int i = 0; i <nums.length ; i++) {
            if(ints[i]==1) continue;
            ints[i] = 1;
            deque.add(nums[i]);
            permute(nums,lists,deque,ints);
            ints[i] = 0;
            deque.removeLast();
        }

    }

    public static void main(String[] args) {
        全排列 c = new 全排列();
        int[] array = {1,2,3};
        System.out.println(c.permute(array));
    }
}
