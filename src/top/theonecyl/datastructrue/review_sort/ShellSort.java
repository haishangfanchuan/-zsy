package top.theonecyl.datastructrue.review_sort;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/5 19:20
 *
 * 希尔排序 ： 插入排序增强-->先分组在排序
 */
public class ShellSort {
    private static int count = 0;

    public static void main(String[] args) {
        int[] array = {5,1,8,9,3,4,2,0};
        System.out.println(Arrays.toString(shellSort(array)) + " " + count);
    }

    private static  int[] shellSort(int[] array){

        for (int i = array.length/2; i >=1; i/=2) { //一共需要进行分组的次数
            for (int j = i; j < array.length; j++) {   //每一组需要比较的次数
                //记录比较数
                int number = array[j];
                //记录比较的下标
                int index  = j;
                while (j >=i && number < array[j-i]){
                    array[j] = array[j-i];
                    j-=i;
                    count++;
                }
                array[j] = number;
                j = index;
            }
        }
        return array;
    }
}
