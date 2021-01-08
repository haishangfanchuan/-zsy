package niucode;

import java.net.URLClassLoader;
import java.util.HashMap;

/**
 * @author shengyun
 * @date 2020/12/29
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，
 * 超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class 数组中出现次数超过一半的数字 {

    public static void main(String[] args) {
        int[] ints = {1};
        System.out.println(MoreThanHalfNum_Solution(ints));
    }

    public static int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        HashMap<Integer, Integer> map = new HashMap<>();
        int ans = 0, num = 0, preMax;
        for (int anInt : array) {
            if (map.containsKey(anInt)) {
                int count = map.get(anInt) + 1;
                map.put(anInt,count);
                preMax = ans;
                ans = Math.max(count,ans);
                if (preMax != ans) num = anInt;
            }else {
                map.put(anInt,1);
            }
        }
        System.out.println(ans);
        if ((array.length >> 1) >= ans) return 0;
        return num;
    }
}

