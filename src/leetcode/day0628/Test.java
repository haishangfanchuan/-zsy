package leetcode.day0628;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String str = "ip route-static xx.vpdn.bj 0.0.0.0 0.0.0.0 Tunnel1204343www preference 100";
        String s = Test.chatChar(str);
        System.out.println(s);


    }

    private static String chatChar(String str) {
        String targetNum = "";
        Pattern p = Pattern.compile("Tunnel" + "[0-9]{1,}");
        Matcher m = p.matcher(str);
        //如果字符串中存在这种类型的字符串就把这个字符串截取出来
        if (m.find()) {
            targetNum = m.group();
            int indexOf = targetNum.indexOf("Tunnel");
            //截取出字符串后面的数字
            targetNum = targetNum.substring(indexOf + 6, targetNum.length());
        }
        return targetNum;
    }

}
