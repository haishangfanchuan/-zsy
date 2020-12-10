package simaite;

/**
 * @author zhangsy
 * @date 2020/9/30 20:27
 */
public class Demo8 {
    public static void main(String[] args) {

    }

    public int[][] method(int row ,int col){
        if(row < 1 || col < 1) return new int[][]{};
        int[][] res = new int[row][col];
        int up = 0, down = row - 1, left = 0, right = col - 1 , num = 1;
        int temp = col * row;
        while (up != down && left != right){
            for (int i = 0; i <= right; i++) {
                res[up][i] = num++;
                if (num > temp) break;
            }
            up++;//顶端向下移动一行
            for (int i = up; i <= down ; i++) {
                res[i][right] = num++;
                if (num > temp) break;
            }
            right --;//有边界向左移动一行
            for (int i = right; i >= left ; i--) {
                res[down][i] = num++;
                if (num > temp) break;
            }
            down--;//下边界向上移动一行
            for (int i = down; i > up ; i--) {
                res[i][left] = num++;
                if (num > temp) break;
            }
            left++;//左边界向右移动一行
        }
        return res;
    }
}
