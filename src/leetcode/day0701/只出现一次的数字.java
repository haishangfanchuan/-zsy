package leetcode.day0701;

import java.util.Arrays;

public class 只出现一次的数字 {

    public static void main(String[] args) {
        只出现一次的数字 s = new 只出现一次的数字();
        int[] nums = {0,1,0,1,0,1,99};
        System.out.println(s.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        if(nums.length==1){
            return nums[0];
        }
        Arrays.sort(nums);
        for (int i = 0; i <nums.length ; i+=3) {
            if(i==nums.length-1&&nums[i]!=nums[i-1]){
                return nums[i];
            }
            if(i+3<nums.length&&nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
        return -1;
    }
}
