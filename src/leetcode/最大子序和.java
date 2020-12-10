package leetcode;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/13 15:47
 * <p>
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 示例:
 * <p>
 * 输入: [-2,1,-3,4,-1,2,1,-5,4]
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 进阶:
 * <p>
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class 最大子序和 {

    public static void main(String[] args) {
        int[] nums = {-2,-1,-3};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int len = nums.length;
        if (len == 0) return 0;
        if (len == 1) return nums[0];
        int sum = 0 , ans = nums[0];
        for(int num : nums){
            if(sum > 0){
                sum+=num;
            }else {
                sum = num;
            }
            ans = Math.max(sum,ans);
        }
        return ans;
    }
}
