package top.theonecyl.datastructrue.review_sort;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/5 19:08
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] array = {5,1,8,9,3,4,2,0};
        System.out.println(Arrays.toString(selectSort(array)));
    }

    public static int[] selectSort(int[] array){
        int temp;
        for (int i = 0; i < array.length; i++) {
            int max = i;
            for (int j = i+1; j < array.length; j++) {
                if(array[j] > array[max]){
                    max = j;
                }
            }
            if(max!=i){
                temp = array[max];
                array[max] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }
}
