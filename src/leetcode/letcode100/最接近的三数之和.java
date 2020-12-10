package leetcode.letcode100;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * 给定一个包括 n 个整数的数组 nums 和 一个目标值 target。
 * 找出 nums 中的三个整数，使得它们的和与 target 最接近。返回这三个数的和。假定每组输入只存在唯一答案。

 示例：

 输入：nums = [-1,2,1,-4], target = 1  //  -4，-1，1，2
 输出：2
 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

 */
public class 最接近的三数之和 {

    public static void main(String[] args) {
        int[] nums = {1,1,1,0};   //0111
        System.out.println(threeSumClosest(nums,100));
    }

    public static int threeSumClosest(int[] nums, int target) {
        if(nums==null || nums.length < 3 ){
            return 0;
        }
        Arrays.sort(nums);
        int tempNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length; i++) {
            int left = i+1 , right = nums.length-1;
            while (left < right){
                int num = nums[i] + nums[left] + nums[right];
                if(Math.abs(target-num) < Math.abs(target - tempNum)) tempNum = num;
                if(num > target) right--;
                else if(num < target) left++;
                else return target;
            }
        }
        return tempNum;
    }
}
