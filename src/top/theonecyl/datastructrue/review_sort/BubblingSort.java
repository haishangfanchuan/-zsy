package top.theonecyl.datastructrue.review_sort;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/5 18:53
 * 冒泡排序
 */
public class BubblingSort {

    public static void main(String[] args) {
        int[] array = {5,1,8,9,3,4,2,0};
        System.out.println(Arrays.toString(bubblingSort(array)));
    }

    private static int[] bubblingSort(int[] array){
        int temp;
        for (int i = 0; i < array.length-1; i++) {  //共需要排序array.length-1次
            for (int j = 0; j < array.length-i-1; j++) {    //每次排序需要比较的次数
                if(array[j] > array[j+1]){
                    temp = array[j];
                    array[j] = array[j+1];
                    array[j+1] = temp;
                }
            }
        }
        return array;
    }
}
