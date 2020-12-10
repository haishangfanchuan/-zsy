package leetcode.letcode100;

import java.util.*;

public class 连续元素序列的长度 {
    public static void main(String[] args) {
        int[] array = {1, 2, 0, 1};
        System.out.println(longestConsecutive(array));
    }

    public static int longestConsecutive(int[] num) {
        // write code here
        if (num.length == 0) {
            return 0;
        }
        if (num.length == 1) {
            return 1;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < num.length; i++) {
            if (!list.contains(num[i])) {
                list.add(num[i]);
            }
        }

        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });
        System.out.println(list);
        int sum = 1;
        int count = 1;
        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size() && list.get(i + 1) == list.get(i) + 1) {
                count = Math.max(count, ++sum);
            } else {
                sum = 1;
            }
        }
        return count;
    }
}
