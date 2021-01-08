package niucode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;

/**
 * @author shengyun
 * @date 2020/12/30
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 示例1
 * 输入
 * [3,32,321]
 * 返回值
 * "321323"
 */
public class 把数组排成最小的数 {
    public static void main(String[] args) {
        new 把数组排成最小的数().PrintMinNumber(new int[]{3,32,321});
    }

    public  String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0) return null;
        if (numbers.length == 1) return String.valueOf(numbers[0]);
        int[] flags = new int[numbers.length];
        ArrayList<Long> list = new ArrayList<>();
        printMinNumber(numbers,flags,new ArrayDeque<>(),list);
        list.sort((Comparator.comparingLong(o -> o)));
        return list.get(0).toString();
    }

    private static void printMinNumber(int [] numbers,int[] flags, Deque<Integer> deque, ArrayList<Long> list) {
        if (deque.size() == numbers.length) {
            Object[] array = deque.toArray();
            StringBuilder sb = new StringBuilder();
            for (Object o : array) sb.append(o);
            list.add(Long.valueOf(sb.toString()));
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (flags[i] == 1) continue;
            flags[i] = 1;
            deque.add(numbers[i]);
            printMinNumber(numbers,flags,deque,list);
            deque.removeLast();
            flags[i] = 0;
        }
    }
}
