package niucode;

import java.util.Arrays;

/**
 * @author shengyun
 * @date 2021/1/5
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。也不知道每个数字重复几次。
 * 请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，
 * 那么对应的输出是第一个重复的数字2。
 * 返回描述：
 * 如果数组中有重复的数字，函数返回true，否则返回false。
 * 如果数组中有重复的数字，把重复的数字放到参数duplication[0]中。（ps:duplication已经初始化，可以直接赋值使用。）
 */
public class 数组中重复的数字 {

    public static void main(String[] args) {
        System.out.println(duplicate(new int[]{6,3,2,0,2,5,0},7,new int[1]));
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        //[6,3,2,0,2,5,0] ==> 2
        if (numbers == null || length < 2) return false;
        int l = 0, r = length - 1;
        while (l < r) {
            if (numbers[l] != numbers[r]) {
                r--;
                if (r == l + 1) {
                    l++;
                    r = length - 1;
                }
            }else {
                duplication[0] = numbers[l];
                return true;
            }
        }
        return false;
    }
}
