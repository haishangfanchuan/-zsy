package simaite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zhangsy
 * @date 2020/9/30 19:52
 */
public class Demo3 {

    public static void main(String[] args) {
        System.out.println();
    }

    public boolean method(String string){
        if(string == null || string.length() < 9) return false;
        List<Character> numList = Arrays.asList('1', '2','3', '4','5','6', '7', '8', '9', '0');
        //以数字开头
        if(numList.contains(string.charAt(0))) return false;

        List<Character> upChar = Arrays.asList('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P'
                , 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');
        List<Character> downChar = Arrays.asList('a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p'
                , 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z');
        boolean up = false,down = false,num = false;
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if(upChar.contains(c))
                up = true;
            else if(downChar.contains(c))
                down = true;
            else if(numList.contains(c))
                num = true;
            else return false;
            if(up && down) return true;
            if(down && num) return true;
            if(up && num) return true;
        }
        return false;
    }
}
