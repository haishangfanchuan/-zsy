package niucode;

import java.util.ArrayList;

/**
 * @author shengyun
 * @date 2020/12/24
 */
public class 顺时针打印矩阵 {

    public static void main(String[] args) {
        int[][] ints = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12},
                {13,14,15,16}
        };
        System.out.println(printMatrix(ints));
    }

    public static ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> list = new ArrayList<>();
        if (matrix == null || matrix.length == 0) return list;
        int l = 0 ,r = matrix[0].length - 1 ,t = 0 ,e = matrix.length - 1;
        while (l <= r && t <= e) {
            for (int i = t; i <= r; i++) {
                list.add(matrix[t][i]);
            }
            t++;
            if (t > e) break;
            for (int i = t; i <= e; i++) {
                list.add(matrix[i][r]);
            }
            r--;
            if (r < l) break;
            for (int i = r; i >= l; i--) {
                list.add(matrix[e][i]);
            }
            e--;
            if (e < t) break;
            for (int i = e; i >= t ; i--) {
                list.add(matrix[i][l]);
            }
            l++;
        }
        return list;
    }
}
