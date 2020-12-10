package simaite;

/**
 * @author zhangsy
 * @date 2020/9/30 19:40
 */
public class Demo2 {

    public static void main(String[] args) {
        System.out.println(new Demo2().method("aa"));
    }

    public String method(String string){
        if(string == null || string.length() < 2) return string;
        int l = 0, r = 1, len = string.length();
        StringBuilder sb = new StringBuilder();
        while (r < len) {
            //遇到重复的字符
            int count = 1;
            while (r < len && string.charAt(l) == string.charAt(r)){
                count++;
                r++;
            }
            if(count > 1) sb.append(count - 1);
            sb.append(string.charAt(l));
            //字符不相等
            l = r;
            if (l == len - 1) sb.append(string.charAt(l));
            r ++;
        }
        return sb.toString();
    }
}
