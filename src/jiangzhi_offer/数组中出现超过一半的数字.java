package jiangzhi_offer;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/22 0:05
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class 数组中出现超过一半的数字 {

    public static void main(String[] args) {
        int[] array = {4,2,1,4,2,4};
        System.out.println(MoreThanHalfNum_Solution(array));
    }
    public static int MoreThanHalfNum_Solution(int[] array) {
        if(array == null) return 0;
        if (array.length == 1) return array[0];
        Arrays.sort(array);
        int l = 0,r= 1;
        double len = array.length;
        double res = len / 2;
        System.out.println(res);
        while (r < len) {
            if (array[l] != array[r]) {
                l = r;
                r++;
            }else {
                r++;
                if (r - l > res) return array[l];
            }
        }
        return 0;
    }

}
