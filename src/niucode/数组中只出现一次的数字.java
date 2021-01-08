package niucode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author shengyun
 * @date 2021/1/4
 *
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。
 * 请写程序找出这两个只出现一次的数字。
 */
public class 数组中只出现一次的数字 {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null || array.length == 0) return;
        Map<Integer, Integer> map = new HashMap<>();
        for (int anInt : array) {
            if (map.containsKey(anInt)) {
                map.remove(anInt);
            }else {
                map.put(anInt,1);
            }
        }
        boolean flag = true;
        for (Integer ans : map.keySet()) {
            if (flag) {
                num1[0] = ans;
                flag = false;
            } else {
                num2[0] = ans;
            }
        }
    }
}
