package leetcode.day0628;

public class 稀疏数组搜索 {

    public static void main(String[] args) {
        稀疏数组搜索 s = new 稀疏数组搜索();
        String[] words = {"at", "", "", "", "ball", "", "", "car", "", "","dad", "", ""};
        int ta = s.findString(words, "ball");
        System.out.println(ta);
    }

    public int findString(String[] words, String s) {
        for(int i=0;i<words.length;i++){
            if(s.equals(words[i])){
                return i;
            }
        }
        return -1;
    }
}
