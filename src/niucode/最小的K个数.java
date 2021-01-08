package niucode;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author shengyun
 * @date 2020/12/30
 *
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。
 * 示例1
 * 输入
 * [4,5,1,6,2,7,3,8],4
 * 返回值
 * [1,2,3,4]
 */
public class 最小的K个数 {

    public static void main(String[] args) {
        int[] ints = {4,5,1,6,2,7,3,8,11,9,12,14,13,15,32,16,12};
        System.out.println(GetLeastNumbers_Solution(ints,4));
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (k >= input.length) break;
            int  min = input[i], index = 0;
            for (int j = i + 1; j < input.length; j++) {
                if (min > input[j]) {
                    min = input[j];
                    index = j;
                }
            }
            int temp;
            if (min != input[i]) {
                temp = input[i];
                input[i] = min;
                input[index] = temp;
            }
            list.add(min);
        }
        return list;
    }
}
