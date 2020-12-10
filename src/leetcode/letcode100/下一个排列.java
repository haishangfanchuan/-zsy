package leetcode.letcode100;

/**
 * @author zhangsy
 * @date 2020/9/8 13:07
 */

import java.util.Arrays;

/**
 *
 * 实现获取下一个排列的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。

    如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。

    必须原地修改，只允许使用额外常数空间。

    以下是一些例子，输入位于左侧列，其相应输出位于右侧列。
    1,2,3 → 1,3,2
    3,2,1 → 1,2,3
    1,1,5 → 1,5,1

 */
public class 下一个排列 {

    public static void main(String[] args) {
        int[] arrays = {1,2};
        nextPermutation(arrays);
    }

    public static void nextPermutation(int[] nums) {
        if(nums==null || nums.length<=1) return;
        int a = nums.length -1, b = a - 1;
        while (true) {
            if (nums[a] <= nums[b]) {
                b--;
                if(b < 0){
                    //当前数为最大数,倒置此数组
                    Arrays.sort(nums);
                    System.out.println(Arrays.toString(nums));
                    break;
                }
                if(nums[a] > nums[b]){
                    int temp = nums[a];
                    nums[a] = nums[b];
                    nums[b] = temp;
                    System.out.println(Arrays.toString(nums));
                    break;
                }
                //b到达0
                if(b==0){
                    a = a - 1;
                    b = a - 1;
                }
            }else{
                int temp = nums[a];
                nums[a] = nums[b];
                nums[b] = temp;
                System.out.println(Arrays.toString(nums));
                break;
            }
        }
    }
}
