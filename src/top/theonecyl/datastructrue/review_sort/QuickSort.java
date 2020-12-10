package top.theonecyl.datastructrue.review_sort;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/5 19:44
 *  快速排序
 *      1、找出一个数，比他大的放在右边，小的放在左边
 *      2、循环1步骤，直到只有一个数为止
 */
public class QuickSort {

    private static int[] array = {5,1,8,9,3,4,2,0};

    public static void main(String[] args) {
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }

    private static int[] quickSort(int[] array,int left,int right){

        if(left==right){
            return array;
        }

        int l = left,r = right,tempNum = array[l],temp;
        while (l < r){
            while (array[l] <= tempNum && l < r){
                l++;
            }
            while (array[r] >= tempNum && l < r){
                r--;
            }
            //找到左右需要交换位置的值 l , r
            if(l < r) {
                temp = array[l];
                array[l] = array[r];
                array[r] = temp;
            }
        }

        // 将基准数放到中间的位置（基准数归位）
        array[left] = array[l];
        array[l] = tempNum;

        //退出while循环时    left=right
        //继续进行下一次排序

        if(left < l)  return  quickSort(array,left,l - 1);
        if(right > r) return quickSort(array,l + 1,right);

        return array;
    }
}
