package leetcode.letcode100;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/9 12:38
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

    示例：

    输入：nums = [1,2,3,4]
    输出：[1,3,2,4]
    注：[3,1,2,4] 也是正确的答案之一。
 */
public class 奇数位于偶数前面 {

    public static void main(String[] args) {
        // 1,4,4,3,5,6,2,7,8
        int[] nums = {1,2};
        System.out.println(Arrays.toString(exchange(nums)));
    }

    public static int[] exchange(int[] nums) {

        if(nums.length < 1) return new int[0];

        int l=0 , r = 1;
        while (r < nums.length){
            if(nums[l] % 2 != 0){
                l++;
                r++;
            }
            if(r < nums.length && nums[l]%2==0 && nums[r]%2!=0) {
                //交换位置
                int temp = nums[l];
                nums[l] = nums[r];
                nums[r] = temp;
                l++;
                r++;
            }
            if(r < nums.length && nums[l]%2==0 && nums[r]%2==0){
                r++;
            }
        }
        return nums;
    }
}
