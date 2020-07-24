package top.theonecyl.datastructrue.sort;

import java.util.Arrays;

/**
 * 快速排序
 *      1、找出一个数，比他大的放在右边，小的放在左边
 *      2、循环1步骤，直到只有一个数为止
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] array = new int[]{10,1,35,61,89,36,55};
        System.out.println(Arrays.toString(quickSort(array,0,array.length-1)));
    }


    /**
     *
     * @param array 需要排序的数组
     * @param left  左指针 最开始为0
     * @param right 右指针 最开始为array.length-1
     * @return
     */
    private static int[] quickSort(int[] array,int left , int right){

        int l  = left;
        int r = right;

        int mid = (left+right)/2;
        int number = array[mid];
        int temp;
        while(left<=right){

            //找出左侧比 number 大的数
            while (number > array[left]){
                left++;
            }
            //找出右侧比 number 小的数
            while(number < array[right]){
                right--;
            }

            if(left>=right){
                break;
            }

            //找到需要交换的值
            temp = array[left];
            array[left] = array[right];
            array[right] = temp;

        }

        //退出while循环时    left=right
        //继续进行下一次排序
        left--;
        right++;

        //左侧排序
        if(left>l){
            quickSort(array,l,left);
        }
        //右侧排序
        if(r>right){
            quickSort(array,right,r);
        }
        return array;
    }
}
