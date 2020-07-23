package leetcode.day0628;

import java.util.Arrays;

public class 寻找重复数 {

    public static void main(String[] args) {
        寻找重复数 s = new 寻找重复数();
        int[] nums = {1,2,3,4,5,6,7,8,9,5};
        int duplicate = s.findDuplicate(nums);
        System.out.println(duplicate);
    }
    public int findDuplicate(int[] nums) {
        int length = nums.length;
        int left = 0;
        int right = length;
        int mid;
        if(length%2==0){
            mid = length/2;
        }
        mid = (length+1)/2-1;

        if(length<=1){
            return nums[1];
        }
        //对数组进行排序
        Arrays.sort(nums);//1,2,3,4,5,5,6,7,8,9



        return -1;

    }
}
