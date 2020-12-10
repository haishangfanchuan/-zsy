package leetcode.letcode100;

import java.util.*;

/**
 * @author zhangsy
 * @date 2020/9/6 15:49
 * <p>
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 * 示例 1：
 * <p>
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 * <p>
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 */
public class 顺时针打印矩阵 {

    public static void main(String[] args) {
//        int[][] matrix = {
//                {1, 2, 3},
//                {5, 6, 7},
//                {9,10,11}};
        int[][] matrix = {
                {1, 2, 3}
                };
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        if(matrix.length==0 || matrix[0].length==0) return list;
        int up = 0 , down = matrix.length -1 , left = 0,right = matrix[0].length - 1;
        while (up <= down && left <= right){
            for (int i = left; i <= right; i++) {
                list.add(matrix[up][i]);
            }
            up++;//上边界向下移动一行
            for (int i = up; i <= down ; i++) {
                list.add(matrix[i][right]);
            }
            right--;//右边界向左移动一列
            for (int i = right; i >= left ; i--) {
                if(left==right)break;
                list.add(matrix[down][i]);
            }
            down--;//下边界向上移动一行
            for (int i = down; i >= up ; i--) {
                list.add(matrix[i][up-1]);
            }
            left++;
        }
        return list;
    }
}
