package niucode;

/**
 * @author shengyun
 * @date 2020/12/31
 *
 * 统计一个数字在升序数组中出现的次数。
 * 示例1
 * 输入
 * [1,2,3,3,3,3,4,5],3
 * 返回值
 * 4
 */
public class 数字在排序数组中出现的次数 {

    public static void main(String[] args) {
        System.out.println(GetNumberOfK(new int[]{3,3,3,3},3));
    }

    public static int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return k == array[0] ? 1 : 0;
        int l = 0, r = array.length - 1, mid;
        boolean flag = false;
        while (l < r) {
            mid = (l + r) >> 1;
            int temp = array[mid];
            if (temp < k)
                l = mid + 1;
            else if (temp > k)
                r = mid - 1;
            else {
                flag = true;
                l = mid;
                break;
            }
        }
        if (!flag) return 0;
        // l 的位置即是k的下标
        int down = l - 1, up = l + 1,count = 1;
        while (true) {
            if (down >= 0 && array[down] == k) {
                down--;
                count++;
            }
            if (up < array.length && array[up] == k) {
                up++;
                count++;
            }else break;
        }
        return count;
    }

}
