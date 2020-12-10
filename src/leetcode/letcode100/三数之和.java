package leetcode.letcode100;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，
 * 使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
 注意：答案中不可以包含重复的三元组。
 示例：
 给定数组 nums = [-1, 0, 1, 2, -1, -4]，
 满足要求的三元组集合为：
 [
 [-1, 0, 1],
 [-1, -1, 2]
 ]
 */
public class 三数之和 {

    public static void main(String[] args) {
        int[] nums = {1,-1,-1,0};
        System.out.println(threeSum(nums));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listList = new ArrayList<List<Integer>>();
        if(nums.length<3){
            return listList;
        }
        //对mums进行排序
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) { // -1,-1,0,1
            if(nums[i] > 0) break;
            if(i>0 && nums[i]==nums[i-1]) continue; //去重
            int left = i+1;
            int right = nums.length-1;
            while (left < right){
                int num = nums[i] + nums[left] + nums[right];
                if(num==0){
                    listList.add(Arrays.asList(nums[i] , nums[left] , nums[right]));
                    while (left < right && nums[left] == nums[left+1]) left++;
                    while (left < right && nums[right] == nums[right-1]) left--;
                    left++;
                    right--;
                }
                else if(num < 0) left++;
                else if(num > 0) right--;
            }
        }
        return listList;
    }
}
