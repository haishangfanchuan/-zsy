package niucode;

/**
 * @author zhangsy
 * @date 2020/9/5 22:07
 *
 * 请实现有重复数字的有序数组的二分查找。
    输出在数组中第一个大于等于查找值的位置，如果数组中不存在这样的数，则输出数组长度加一。
    示例1
    输入

    5,4,[1,2,4,4,5]

    输出

    3
 */
public class 二分查找 {

    public static void main(String[] args) {
        //5,4,[1,2,4,4,5]
        //10,2,[1,1,2,3,7,7,7,9,9,10]
        int[] array = {1,1,2,3,7,7,7,9,9,10};
        System.out.println(upper_bound_(10,2,array));
    }

    /**
     * 二分查找
     * @param n int整型 数组长度
     * @param v int整型 查找值
     * @param a int整型一维数组 有序数组
     * @return int整型
     */
    public static int upper_bound_ (int n, int v, int[] a) {
        // write code here
        int l = 0,r = n-1;
        while (l <= r){
            int mid = (l+r)/2;
            if(a[mid] == v) return mid;
            if(v > a[mid]) l = mid + 1;
            else if(v < a[mid]) r = mid -1;
        }
        return n+1;
    }
}
