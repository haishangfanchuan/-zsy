package daxi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/14 18:53
 * <p>
 * 给定⼀个按开始时间从⼩到⼤排序的时间区间集合，请将重叠的区间合并。时
 * 间区间集合⽤⼀个⼆维数组表示，⼆维数组的每⼀⾏表示⼀个时间区间（闭区
 * 间），其中 0 位置元素表示时间区间开始，1 位置元素表示时间区间结束。
 * <p>
 * 例 1：输⼊：[ [1, 3], [2, 6] ,[8, 10], [15, 18] ]
 * 返回： [ [1, 6], [8, 10], [15, 18]]
 * 解释：时间区间 [1, 3] 和 [2, 6] 有部分重叠，合并之后为 [1, 6]
 * <p>
 * 例 2：输⼊：[[1, 4], [4, 5]]
 * 返回：[[1, 5]]
 * 解释：时间区间[1，4] 和 [4，5]重叠了⼀个时间点，合并之后为 [1，5]
 * 需要实现的⽅法原型：int[][] merge(int[][] intervals)
 * <p>
 * [[3,9],[2,6]]
 */
public class 合并时间区间 {

    public static void main(String[] args) {
//        int[][] intervals = {
//                {1, 3},
//                {2, 6},
//                {8,10},
//                {15,18}
//        };
        int[][] intervals = {
                {2, 3}
                , {4, 5}
                , {6, 7}
                , {8, 9}
                , {1, 10}
        };
        Arrays.sort(intervals);
        合并时间区间 c = new 合并时间区间();
        c.print(intervals);
//        c.print(c.merge(intervals));
    }

    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0 || intervals[0].length == 0)
            return new int[][]{};
        if (intervals.length == 1) return intervals;
        int len = intervals.length, l = 0, r = 1;
        List<Object> list = new ArrayList<>();

        while (r < len) {
            boolean flag = true;
            int[] ints = isInner(intervals[l], intervals[r]);
            while (ints != null) {
                flag = false;
                if (r >= len) {
                    list.add(ints);
                    break;
                }
                int[] inner = isInner(ints, intervals[r]);
                if (inner != null) {
                    r++;
                    ints = inner;
                } else {
                    //将ints添加到目标二维数组中
                    list.add(ints);
                    break;
                }
            }
            //如果不能合并就单独添加
            if (flag) {
                list.add(intervals[l]);
                list.add(intervals[r]);
            }
            //进行下一轮判定
            l = r;
            r++;
        }
        int[][] res = new int[list.size()][2];
        int index = 0;
        for (Object o : list) {
            int[] ints = (int[]) o;
            for (int i = 0; i < ints.length; i++) {
                res[index][i] = ints[i];
            }
            index++;
        }
        return res;
    }

    //合并两个时区
    private int[] isInner(int[] interval1, int[] interval2) {
        int num0 = interval1[0];
        int num1 = interval1[1];
        int num2 = interval2[0];
        int num3 = interval2[1];
        int[] res = new int[2];
        if (num1 >= num2 && num1 <= num3) {
            if (num0 >= num2) {
                return interval2;
            } else {
                res[0] = num0;
                res[1] = num3;
                return res;
            }
        } else if (num3 >= num0 && num3 <= num1) {
            if (num2 >= num0) return interval1;
            res[0] = num2;
            res[1] = num1;
            return res;
        }
        return null;
    }


    private void print(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
