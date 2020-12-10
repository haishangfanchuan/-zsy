package simaite;

import java.util.Arrays;

/**
 * @author zhangsy
 * @date 2020/9/30 20:38
 */
public class Demo7 {

    public static void main(String[] args) {
        System.out.println(new Demo7().method("12", "20"));
    }

    public String method(String string1, String string2) {
        if (string1 == null || string2 == null || string1.length() == 0 || string2.length() == 0)
            return null;
        char[] num1Char = string1.toCharArray();
        char[] num2Char = string2.toCharArray();
        int len1 = num1Char.length, len2 = num2Char.length, index = len1 + len2 - 1;
        int tempIndex = index;
        int[] res = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            int num1 = num1Char[i] - '0';
            for (int j = len2 - 1; j >= 0; j--) {
                int num2 = num2Char[j] - '0';
                //获取两数乘积十位上的数
                int tempNum = (num1 * num2) / 10;
                //取个位数
                res[index] += (num1 * num2) % 10;
                index--;
                if(index < 0) break;
                res[index] += tempNum;
            }
            tempIndex--;
            index = tempIndex;
        }
        System.out.println(Arrays.toString(res));
        StringBuilder sb = new StringBuilder();
        boolean flag = true;
        for (int ints : res) {
            if(ints == 0 && flag) continue;
            else flag = false;
            sb.append(ints);
        }
        return sb.toString();
    }
}
