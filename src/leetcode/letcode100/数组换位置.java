package leetcode.letcode100;

import java.util.Arrays;

/**
 * @author zhangsy
 * @version 1.0
 * @description
 * @date 2020/9/4 19:22
 * 将数组的 0 ~ k-1 位，与 k ~ n-1 换位置
 */
public class 数组换位置 {

    private static  int count = 0;
    private static int[] array = {1,2,3,4,5,6,7,8,9};

    public static void main(String[] args) {
//        int[] array = {1,2,3,4,5,6,7,8,9};
//        System.out.println(Arrays.toString(transArray(array,5,7)));
        transArray(array,5,7);
        System.out.println(array);
        System.out.println(count);
    }


//    private static int[] transArray(int [] array,int k,int n){
//        int[] temp = new int[k];
//        for (int i = 0; i <= k - 1; i++) {
//            count++;
//            temp[i] = array[i];
//            if(n - 1 >= i + k)  array[i] = array[i+k];
//        }
//        int index = 0;
//        for (int i = n - k; i < n; i++) {
//            count++;
//            array[i] = temp[index];
//            index++;
//        }
//        return array;
//    }
public static void transArray(int[] a, int k, int n) {
    reverse(a, 0, k-1);
    reverse(a, k, n-1);
    reverse(a, 0, n-1);

}
    public static void reverse(int[] a, int i, int j) {
        int temp;
        while (i < j) {
            count++;
            temp = a[i];
            a[i] = a[j];
            a[j] = temp;
            i++;
            j--;
        }
    }
}
