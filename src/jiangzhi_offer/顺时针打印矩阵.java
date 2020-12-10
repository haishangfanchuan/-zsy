package jiangzhi_offer;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author zhangsy
 * @date 2020/9/19 16:58
 */
public class 顺时针打印矩阵 {

    public static void main(String[] args) {
//        int[][] array = {
//                {1,2,3,4}
//                ,{5,6,7,8}
//                ,{9,10,11,12}
//                ,{13,14,15,16}
//                ,{17,18,19,20}
//                ,{21,22,23,24}
//        };
        int[][] array = {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20},
                {21,22,23,24,25}};
        System.out.println(printMatrix(array));

        ReentrantLock lock = new ReentrantLock(true);
        Stack<Integer> stack = new Stack<>();
    }


    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0) return null;
        ArrayList<Integer> list = new ArrayList<>();
        int up = 0, down = matrix.length -1, left = 0, right = matrix[0].length -1,count = (right + 1) * (down + 1), temp = 0;
        while (up <= down || left <= right) {
            for (int i = 0; i <= right ; i++) {
                if(temp >=count) break;
                list.add(matrix[up][i]);
                temp++;
            }
            up++;//上边界下一行
            for (int i = up; i <=down ; i++) {
                if(temp >=count) break;
                list.add(matrix[i][right]);
                temp++;
            }
            right--;//右边界左移一行
            for (int i = right; i >=left ; i--) {
                if(temp >=count) break;
                list.add(matrix[down][i]);
                temp++;
            }
            down--;//下边界上移动一行
            for (int i = down; i > up ; i--) {
                if(temp >=count) break;
                list.add(matrix[i][left]);
                temp++;
            }
            left++;//左边界右移一行
        }
        return list;
    }
}

