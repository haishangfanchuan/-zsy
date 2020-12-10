package leetcode.letcode100;

/**
 * @author zhangsy
 * @date 2020/9/12 14:41
 *
 * 反转一个有序数组，不允许使用额外的空间
 */
public class 数组反转 {

    public void reverseArray(int[] array,int index){

        if(index > array.length) return;
        int[] ans = new int[index + 1];
        for (int i = 0; i < array.length; i++) {
            if(i <= index)
                ans[i] = array[i];
            else {
                //记录需要移动的数
                array[i - index - 1] = array[i];
            }
        }
    }
}
