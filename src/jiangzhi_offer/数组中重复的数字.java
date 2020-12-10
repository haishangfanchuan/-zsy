package jiangzhi_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangsy
 * @date 2020/9/28 1:11
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。
 * 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中任意一个重复的数字。
 * 例如，如果输入长度为7的数组{2,3,1,0,2,5,3}，那么对应的输出是第一个重复的数字2。
 */
public class 数组中重复的数字 {

    public static void main(String[] args) {
        int numbers[] = {2,3,1,0,2,5,3};
        int duplication[] = {2};
        System.out.println(duplicate(numbers,7,duplication));
    }

    public static boolean duplicate(int numbers[],int length,int [] duplication) {
        if(numbers == null || length == 0) return false;
        Map<Integer, Integer> map = new HashMap<>();
        for (int  anInt  : numbers) {
            if(map.containsKey(anInt))
                map.put(anInt,map.get(anInt) + 1);
            else map.put(anInt,1);
        }
        return map.containsKey(duplication[0]) && map.get(duplication[0]) != 1;
    }
}
