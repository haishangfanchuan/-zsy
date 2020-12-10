package leetcode.letcode100;

/**
 * @author zhangsy
 * @date 2020/9/9 16:26
 * <p>
 * 假设按照升序排序的数组在预先未知的某个点上进行了旋转。
 * <p>
 * ( 例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] )。
 * <p>
 * 搜索一个给定的目标值，如果数组中存在这个目标值，则返回它的索引，否则返回 -1 。
 * <p>
 * 你可以假设数组中不存在重复的元素。
 * <p>
 * 你的算法时间复杂度必须是 O(log n) 级别。
 * <p>
 * 示例 1:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 0
 * 输出: 4
 * 示例 2:
 * <p>
 * 输入: nums = [4,5,6,7,0,1,2], target = 3
 * 输出: -1
 */
public class 搜索旋转排序数组 {

    public static void main(String[] args) {
        int[] array = {1,3};
        System.out.println(search(array,4));
    }

    private static int search(int[] nums, int target) {
        if(nums==null || nums.length==0) return -1;
        if(nums.length==1) return nums[0]==target ? 0:-1;
        int len = nums.length-1,num = nums[len];
        //不存在此数情况
        if(target > num && target < nums[0]){
            return -1;
        }
        //存在次数
        if(target==num) return len;
        if(target > num){
            //从0开始搜索
            len = 0;
            while (len < nums.length && nums[len] <= target){
                if(target==nums[len]) return len;
                len++;
            }
        }
        if(target < num){
            //从len先前搜索
            while (len >=0 && nums[len] >= target){
                if(target==nums[len]) return len;
                len--;
            }
        }
        return -1;
    }
}
