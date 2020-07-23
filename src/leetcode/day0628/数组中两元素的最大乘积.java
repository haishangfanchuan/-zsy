package leetcode.day0628;

public class 数组中两元素的最大乘积 {

    public static void main(String[] args) {
        数组中两元素的最大乘积 s = new 数组中两元素的最大乘积();
        int[] nums = {1,5,5,6,4};
        System.out.println(s.maxProduct(nums));

    }
    public int maxProduct(int[] nums) {
        for(int i=0;i<nums.length;i++){
            int min = i;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]<nums[min]){
                    min=j;
                }
            }
            if(min!=i){
                int temp;
                temp=nums[min];
                nums[min]=nums[i];
                nums[i]=temp;
            }
        }
        for(int num:nums){
            System.out.println(num);
        }
        return (nums[nums.length-1]-1)*(nums[nums.length-2]-1);
    }
}
