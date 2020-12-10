package leetcode.letcode100;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/9 16:59
 * <p>
 * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 如果数组中不存在目标值，返回 [-1, -1]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 8
 * 输出: [3,4]
 * 示例 2:
 * <p>
 * 输入: nums = [5,7,7,8,8,10], target = 6
 * 输出: [-1,-1]
 */
public class 在排序数组中查找元素的第一个和最后一个位置 {

    public static void main(String[] args) {
//        int[] array = {5,7,7,8,8,10};
        int[] array = {2,2};
        System.out.println(Arrays.toString(searchRange(array,2)));
    }


    public static int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
//        if (nums.length == 1) return nums[0]==target ?  new int[]{0, 0}:new int[]{-1, -1};
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]==target){
                flag = true;
                break;
            }
        }
        if(!flag) return new int[]{-1, -1};
        int l = 0, r = nums.length;
        int mid = (l + r) >>1;
        while (mid >=0) {
            if(mid==0 && (target!=nums[mid])) break;
            mid = (l + r) >>1;
            if(nums[mid] == target){
                int[] ints = new int[2];
                //判断是否存在多个target
                int a = mid -1, b = mid + 1;
                while (true){
                    if(a > 0 && nums[a]==target) a--;
                    else if(b < nums.length && nums[b]==target) b++;
                    else break;
                }
                ints[0] = a + 1;
                ints[1] = b - 1;
                return ints;
            }
            if (target > nums[mid]) {
                l = mid;
            }else {
                r = mid;
            }
        }
        return new int[]{-1, -1};
    }
}
