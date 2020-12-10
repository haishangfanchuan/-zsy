package leetcode.letcode100;

/**
 * @author shengyun
 * @date 2020/10/28 19:37
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给你一个整数数组 arr，请你帮忙统计数组中每个数的出现次数。
 * <p>
 * 如果每个数的出现次数都是独一无二的，就返回 true；否则返回 false。
 * <p>
 * 示例 1：
 * <p>
 * 输入：arr = [1,2,2,1,1,3]
 * 输出：true
 * 解释：在该数组中，1 出现了 3 次，2 出现了 2 次，3 只出现了 1 次。没有两个数的出现次数相同。
 * 示例 2：
 * <p>
 * 输入：arr = [1,2]
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：arr = [-3,0,1,-3,1,1,1,-3,10,0]
 * 输出：true
 */
public class 独一无二的出现次数 {

    public static void main(String[] args) {
        boolean b = uniqueOccurrences(new int[]{1,2,2,3});
        System.out.println(b);
    }

    public static boolean uniqueOccurrences(int[] arr) {
        if (arr == null || arr.length == 0) return false;
        if (arr.length == 1) return true;
        Arrays.sort(arr);
        List<Integer> list = new ArrayList<>();
        int l = 0, r = 1,temp = 0;
        //2,3,3,5,6
        while (r < arr.length && l <= r) {
            temp ++;
            if (arr[l] == arr[r])
                r++;
            else {
                if (r - l == 1 && r == arr.length - 1) return false;
                int count = r - l;
                if (list.contains(count)) return false;
                list.add(count);
                l = r;
                r++;
            }
        }
        return temp > 1;
    }
}
