package top.theonecyl.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 希尔排序
 *      1、先是将数组分为若干组，小组内先进行排序
 *      2、第一个group = array.length/2 ;   group = group/2;
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] array = new int[]{8,3,7,9,0,5,1,4,2,6};
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(format);
//        int[] array = new int[1000000];
//        for (int i = 0; i <array.length ; i++) {
//            array[i] = new Random().nextInt(9999999);
//        }
        System.out.println(Arrays.toString(shellSort(array)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

    //1、移位的方式
    private static int[] shellSort(int[] array){

        //需要进行分组的次数
        for (int group = array.length/2; group >0 ; group/=2) {
            //从第group个元素开始，对其所在其的组进行插入排序
            for (int i = group; i <array.length ; i++) {
                //比较数
                int number = array[i];
                while(i-group >= 0 && number < array[i-group]){
                    array[i] = array[i-group];
                    i-=group;
                }
                array[i] = number;
            }
        }
        return array;
    }
}
