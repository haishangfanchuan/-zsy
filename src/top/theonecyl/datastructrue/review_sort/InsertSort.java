package top.theonecyl.datastructrue.review_sort;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/5 19:13
 * 插入排序
 */
public class InsertSort {

    private static int count = 0;

    public static void main(String[] args) {
        int[] array = {5,1,8,9,3,4,2,0};
        System.out.println(Arrays.toString(insertSort(array)) + " " +count);
    }

    private static  int[] insertSort(int[] array){
        //从第二个开始先前依次比较
        for (int i = 1; i < array.length; i++) {
            //记录被比较的数
            int number = array[i];
            //记录被比较的数下标
            int index = i;
            while (i >= 1 && number < array[i-1]){ //在i之前比number大的数
                array[i] = array[i-1];
                i--;
                count++;
            }
            array[i] = number;
            i = index;
        }
        return array;
    }
}
