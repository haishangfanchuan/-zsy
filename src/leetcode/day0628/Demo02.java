package leetcode.day0628;


import java.util.HashMap;
import java.util.Map;

public class Demo02 {

    public static void main(String[] args) {
        Demo02 demo02 = new Demo02();
        String method = demo02.method("Hello python. Hello world");
        System.out.println(method);
    }

    public String method(String string){
        Map<String, Integer> map = new HashMap<>();
        int temp=1;
        String[] split = string.split("\\s");
        for (int i = 0; i <split.length ; i++) {
            if(map.containsKey(split[i])){
                temp++;
                map.put(split[i],temp);
            }else{
                map.put(split[i],1);
            }
        }
        return map.toString();
    }
}
