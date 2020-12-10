package leetcode.letcode100;

import java.util.*;

/**
 * @author zhangsy
 * @date 2020/9/10 21:06
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 */
public class 字符串相乘 {

    public static void main(String[] args) {
//        System.out.println(multiply("123", "456"));
        int[] array = {8,1,2,2,3};
        System.out.println(Arrays.toString(printNames(array)));
    }

    public static String multiply(String num1, String num2) {

        if(num1.equals("0") || num2.equals("0")) return "0";

        //M*N 得到結果的最大位數 为 M + N
        int m = num1.length(),n = num2.length();
        int[] ints = new int[m + n];
        for (int i = m -1 ; i >= 0; i--) {
            int a = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; j--) {
                int b = num2.charAt(j) - '0';
                int sum = (ints[i + j + 1] + a * b);
                ints[i + j + 1] = sum%10;
                ints[i + j] +=  sum / 10;
            }
        }
//        System.out.println(Arrays.toString(ints));
        int temp = 0;
        StringBuilder sb = new StringBuilder();
        for(int num : ints){
            if(temp==0 && num==0) continue;
            sb.append(num);
            temp++;

        }

        return sb.toString();
    }

    public int smallestDifference (int[] a, int[] b) {
        // write code here
        if(a.length == 0 || b.length==0) return 0;
        int res = Integer.MAX_VALUE;
        for (int i = 0;i < a.length;i++) {
            for (int j = 0 ; j < b.length ;j++) {
                res = Math.min(Math.abs(a[i] - b[j]) , res);
            }
        }
        return res;
    }

    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * @param nums int整型一维数组
     * @return int整型一维数组
     */
    public static int[] printNames (int[] nums) {
        // write code here
        if(nums==null || nums.length==0) return new int[]{};
        int size = nums.length;
        int[] res = new int[size];
        int[] temp = Arrays.copyOf(nums,size);
        Arrays.sort(temp);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if(!map.containsKey(temp[i]))
                map.put(temp[i],i);
        }
        for (int i = 0; i < size; i++) {
            res[i] = map.get(nums[i]);
        }
        return res;
    }

}
