package leetcode.letcode100;

/**
 * @author zhangsy
 * @date 2020/9/14 23:41
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。

示例:

输入: 3
输出:
[
[ 1, 2, 3 ],
[ 8, 9, 4 ],
[ 7, 6, 5 ]
]

 *
 */
public class 螺旋矩阵2 {

    public static void main(String[] args) {
        int[][] ints = generateMatrix(5);
        print(ints);
    }

    public static int[][] generateMatrix(int n) {
        if(n<=0) return new int[][]{};
        int[][] ints = new int[n][n];
        int up = 0, down = n - 1, left = 0, right = n -1;
        int temp = 1;
        while (up<=down && left <=right) {

            for (int i = up; i <= right; i++) {
                ints[up][i] = temp++;
                if(temp > n * n) break;
            }
            //上边界向下移动一行
            up++;
            for (int i = up; i <= down; i++) {
                ints[i][right] = temp++;
                if(temp > n * n) break;
            }
            //有边界向左移动一行
            right--;
            for (int i = right; i >= left ; i--) {
                ints[down][i] = temp++;
                if(temp > n * n) break;
            }
            //下边界向上移动一行
            down--;
            for (int i = down; i >= up ; i--) {
                ints[i][left] = temp++;
                if(temp > n * n) break;
            }
            //左边界向右移动一行
            left++;
        }
        return ints;
    }

    //打印二维数组
    private static void print(int[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
