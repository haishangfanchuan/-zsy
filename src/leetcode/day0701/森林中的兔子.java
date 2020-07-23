package leetcode.day0701;

import java.util.*;

public class 森林中的兔子 {

    public static void main(String[] args) {
        森林中的兔子 s = new 森林中的兔子();
        int[] answers = {0,1,0,2,0,1,0,2,1,1};
        System.out.println(s.numRabbits(answers));
    }

    public int numRabbits(int[] answers) {
        //没有人回答
        if(answers==null){
            return 0;
        }
        Arrays.sort(answers);
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i <answers.length ; i++) {
            int temp=0;
            if(!map.containsKey(answers[i])){
                for (int j = i; j <answers.length ; j++) {
                    if(i!=answers.length-1&&answers[j]>answers[i]){
                        break;
                    }
                    if(answers[i]==answers[j]){
                        temp++;
                        map.put(answers[i], temp);
                    }else {
                        map.put(answers[i],temp);
                    }
                }
            }
        }
        Set<Integer> keySet = map.keySet();
        for(Integer key : keySet){
            if(key==0){
                count+=map.get(key);
            }else {
                if(map.get(key)%(key+1)==0) {
                    count += (key + 1) * (map.get(key) / (key + 1));
                }else{
                    count += (key + 1) * (map.get(key) / (key + 1)+1);
                }
            }
        }
        return count;
    }
}
