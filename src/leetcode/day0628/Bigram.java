package leetcode.day0628;

import java.util.ArrayList;
import java.util.List;

public class Bigram {

    public static void main(String[] args) {
        Bigram bigram = new Bigram();
        String[] ocurrences = bigram.findOcurrences("jkypmsxd jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa jkypmsxd kcyxdfnoa kcyxdfnoa jkypmsxd kcyxdfnoa",
                "kcyxdfnoa"
                ,"jkypmsxd");
    }


    public String[] findOcurrences(String text, String first, String second) {
        String[] words = text.split("\\s");
        List<String> strings = new ArrayList<>();
        for(int i=0;i<words.length;i++){
            if(words.length>=i+2&&first.equals(words[i])&&second.equals(words[i+1])){
                strings.add(words[i+2]);
            }
        }
        for(String string:strings){
            System.out.println(string);
        }
        return strings.toArray(new String[strings.size()]);
    }
}
