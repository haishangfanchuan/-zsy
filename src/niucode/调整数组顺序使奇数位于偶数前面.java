package niucode;

import java.util.Arrays;

/**
 * @author shengyun
 * @date 2020/12/4
 */
public class 调整数组顺序使奇数位于偶数前面 {

    public static void main(String[] args) {
//        int[] ints = {1, 2, 4, 3, 6, 5, 11, 7, 8, 9};
        int[] ints = {1,3,5,7,2,4,6};
        reOrderArray(ints);
        System.out.println(Arrays.toString(ints));
    }

    public static void reOrderArray(int [] array) {
        int len = array.length;
        if (len == 1) return;
        //1,2,4,3,6,5,11,7,8,9
        int count = 0;
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 != 0) continue;
            //如果是奇数不变,偶数就继续往后寻找，直到碰见奇数，奇数先前移动偶数个数位
            int  index = i + count;
            if (index >= len) break;
            if (array[index] % 2 == 0) {
                while (index < len -1) {
                    index++;
                    count++;
                    if (array[index] % 2 != 0) break;
                }
            }
            if (array[index] % 2 == 0) break;
            //退出时：index位置即为最近的奇数下标，count即为偶数个数
            int num = array[index] , tempIndex = i, tempNum = array[tempIndex], tempNum2;
            while (tempIndex < index) {
                tempNum2 = array[tempIndex + 1];
                array[tempIndex + 1] = tempNum;
                tempIndex++;
                tempNum = tempNum2;
            }
            array[i] = num;
        }
    }
}
