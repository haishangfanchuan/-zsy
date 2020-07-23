package top.theonecyl.datastructrue.sort;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 选择排序
 */
public class SelectSort {
    public static void main(String[] args) {

        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(format);
        int[] array = new int[100000];
        for (int i = 0; i <10000 ; i++) {
            array[i] = (int) (Math.random()*9999999);
        }
        selectSort(array);
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    private static int[] selectSort(int[] array){
        int temp;
        for (int i = 0; i <array.length ; i++) {
            //默认最大或者最小数下标为i
            int max = i;
            for (int j = i+1; j <array.length ; j++) {
                if(array[max]<array[j]){
                    max = j;
                }
            }

            //判断是否发生交换
            if(max!=i){
                temp = array[max];
                array[max] = array[i];
                array[i] = temp;
            }
        }
        return array;
    }

    private static void print(int[] array){
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }
}
