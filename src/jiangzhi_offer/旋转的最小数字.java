package jiangzhi_offer;

/**
 * @author zhangsy
 * @date 2020/9/17 12:55
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
例如数组[3,4,5,1,2]为[1,2,3,4,5]的一个旋转，该数组的最小值为1。
NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */
public class 旋转的最小数字 {



    public int minNumberInRotateArray(int [] array) {
        if(array==null || array.length==0) return 0;
        if(array.length==1) return array[0];
        for (int i = array.length - 1; i >=0 ; i--) {
            if(i - 1 < 0 || array[i - 1] > array[i]){
                return array[i];
            }
        }
        return 0;
    }
}
