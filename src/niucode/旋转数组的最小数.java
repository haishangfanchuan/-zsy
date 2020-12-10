package niucode;

/**
 * @author shengyun
 * @date 2020/12/3
 */
public class 旋转数组的最小数 {

    public static void main(String[] args) {
        System.out.println(minNumberInRotateArray(new int[]{4,3}));
    }

    public static int minNumberInRotateArray(int [] array) {
        int l = 0, r = array.length - 1;
        if (r < 0) return 0;
        if (r == 0) return array[0];
        while (l < r) {
            if (array[l] < array[r]) return array[l];
            int mid = (l + r) >> 1;
            if (array[mid] > array[r]) {
                //目标数一定在mid的右边
                l = mid + 1;
            }else if (array[mid] < array[r]) {
                //目标数一定在mid左边，但是有可能等于mid
                r = mid;
            }else{
                r--;
            }
        }
        return array[l];
    }

}
