package top.theonecyl.datastructrue.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Random;

/**
 * 插入排序
 *      理论分为有序表和无序表，每次从有序表中拿出一个元素放入无序表中
 *      实际上还是一个数组，下标为index的数与之前的数一一对比，找到插入的位置
 */
public class insertSort {

    public static void main(String[] args) {
        Date date = new Date();
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
        System.out.println(format);
        int[] array = new int[100000];
        for (int i = 0; i <10000 ; i++) {
            array[i] = new Random().nextInt(9999999);
        }
        System.out.println(Arrays.toString(insetSort(array)));
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }



    private static int[] insetSort(int[] array) {
        //1、从第二个数开始比较
        //2、风别与前面的数比较，知道找到插入的位置
        for (int i = 1; i <array.length ; i++) {
            //被比数的下标
            int index = i-1;
            //先保存比较数
            int number = array[i];
            //1、保证数不越界
            //1、找到需要停止比较的下标位置+1
            while(i>=0 && index>=0 &&number < array[index]){
                //被比较数向后移动一位
                array[index+1] = array[index];
                index--;
                i--;
            }
            //退出while循环找到插入的位置 index
            array[index+1] = number;
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
