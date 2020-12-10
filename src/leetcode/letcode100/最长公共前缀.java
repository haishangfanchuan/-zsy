package leetcode.letcode100;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。

 如果不存在公共前缀，返回空字符串 ""。

 示例 1:

 输入: ["flower","flow","flight"]
 输出: "fl"
 示例 2:

 输入: ["dog","racecar","car"]
 输出: ""
 解释: 输入不存在公共前缀。

 */
public class 最长公共前缀 {

    public static void main(String[] args) {
        String[] strings = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strings));
    }

    public static String longestCommonPrefix(String[] strs) {

        if(strs.length==0){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        String stringMin = strs[0];
        for (int i = 0; i < strs.length; i++) {
            if(strs[i].equals("")){
                return "";
            }
            stringMin = strs[i].length() < stringMin.length() ? strs[i] : stringMin;
        }
        int temp = 0;
        int index = 0;
        while (true){
            while (temp<strs.length) {
                if (strs[temp].charAt(index) == stringMin.charAt(index)) {
                    temp++;
                }else {
                    break;
                }
            }
            if(temp==strs.length) {
                sb.append(stringMin.charAt(index));
                temp=0;
            }else {
                break;
            }
            if(index==stringMin.length()-1)
                return sb.toString();
            index++;
        }
        return sb.toString();
    }
}
