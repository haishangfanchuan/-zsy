package leetcode.letcode100;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/4 21:20
 * 1,2,3,4,5,6可以组成多少无重复的三个数字
 */
public class Demo0904 {
    public static void main(String[] args) {
        int[] array = {1,2,3,4};
        System.out.println(countThreeNumCount(array));
    }

    public static int countThreeNumCount(int[] array){
        Arrays.sort(array);
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(i+1 < array.length && array[i+1]==array[i]) continue;
            int left = i + 1;
            int right = array.length;
            while (left < right){
                count++;
                left++;
            }
        }
        return count;
    }
}
