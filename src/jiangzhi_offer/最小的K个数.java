package jiangzhi_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/22 0:22
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4
 */
public class 最小的K个数 {

    public static void main(String[] args) {
        最小的K个数 c = new 最小的K个数();
        int[] array = {4,5,1,6,2,7,3,8};
        System.out.println(c.GetLeastNumbers_Solution(array,4));
    }

    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        if(input == null || input.length < k) return res;
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            if (i < k) res.add(input[i]);
        }
        return res;
    }

    private void fun(ArrayList<Integer> list, int num) {
        for (int i = 0; i < list.size(); i++) {
            if (num < list.get(i)) {
                list.set(i,num);
                break;
            }
        }
    }
}
