package jiangzhi_offer;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/18 13:01
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class 奇数位于偶数前面 {
    public static void main(String[] args) {
        int[] array = {1,2,3};
        reOrderArray(array);
    }

    public static void reOrderArray(int [] array) {
        if (array == null || array.length == 0 || array.length==1) return;
        //2,1,3,4,6,5,8,9
        int temp = 1;
        for (int i = 1; i < array.length; i++) {
            int num = array[i] , index =i;
            while (array[index]%2!=0) {
                //在次数之前存在奇数
                while (index > 0 && array[index - 1]%2==0) {
                    temp = 0;
                    array[index] = array[index - 1];
                    index--;
                }
                if (temp==1) break;
            }
            array[index] = num;
        }
        System.out.println(Arrays.toString(array));
    }
}
