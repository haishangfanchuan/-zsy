package leetcode.letcode100;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/6 21:30
 */
public class Demo0906 {

    public static void main(String[] args) {
        int[][] array = new int[11][11];
        array[1][2] = 1;
        array[2][3] = 2;

        int[][] method = method(array);
        for(int[] ints : method){
            System.out.println();
            for (int i : ints){
                System.out.print(i);
            }
        }

    }


    public static int[][] method(int[][] array){

        int[][] copy = new int[2][3];
//        int[][] copy = null;
        int temp = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if(array[i][j]!=0){
//                    copy = Arrays.copyOf(ints, ints.length + 1);
                    copy[temp][0] = i;
                    copy[temp][1] = j;
                    copy[temp][2] = array[i][j];
                    temp++;
                }
            }
        }
        return copy;
    }
}
