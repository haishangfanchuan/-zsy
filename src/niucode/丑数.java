package niucode;

import java.util.Arrays;
import java.util.List;

/**
 * @author shengyun
 * @date 2020/12/30
 *
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。
 * 例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 示例1
 * 输入
 * 7
 * 返回值
 * 8
 */
public class 丑数 {

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution(10));
    }
    public static  int GetUglyNumber_Solution(int index) {
        if (index <= 0) return 0;
        //丑数 = 丑数 * 2/3/5  1,2,3,4,5,6,8,9,10,12
        int[] ans = new int[index];
        int a = 0, b = 0, c = 0;
        ans[0] = 1;
        for (int i = 1; i < index; i++) {
            int min = Math.min(ans[a] * 2, Math.min(ans[b] * 3, ans[c] * 5));
            if (min == ans[a] * 2) a++;
            if (min == ans[b] * 3) b++;
            if (min == ans[c] * 5) c++;
            ans[i] = min;
        }
        return ans[index -1];
    }
}
