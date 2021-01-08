package niucode;

import java.util.ArrayList;

/**
 * @author shengyun
 * @date 2021/1/4
 *
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，
 * 如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * 示例1
 * 输入
 * [1,2,4,7,11,15],15
 * 返回值
 * [4,11]
 */
public class 和为S的两个整数 {

    public static void main(String[] args) {
        System.out.println(FindNumbersWithSum(new int[]{1,2,4,7,11,15},20));
    }

    public static ArrayList<Integer> FindNumbersWithSum(int [] array, int sum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (array == null || array.length < 2) return list;
        int l = 0, r = l + 1, temp;
        while (l < r && r < array.length) {
            temp = array[l] + array[r];
            if (temp < sum) {
                l++;
                r++;
            } else if (temp > sum) {
                if (l - 1 >= 0) l--;
            }else {
                list.add(array[l]);
                list.add(array[r]);
                break;
            }
        }
        return list;
    }
}
