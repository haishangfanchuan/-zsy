package simaite;

/**
 * @author zhangsy
 * @date 2020/9/30 20:10
 */
public class Demo4 {

    public static void main(String[] args) {
        System.out.println(new Demo4().method("a1223a"));
    }

    public String method(String string){
        if(string == null || string.length() == 1) return string;
        int l = 0, len = string.length(),r = len - 1;
        StringBuilder sb = null;
        while (l != r){
            sb = new StringBuilder();
            while (l != r && string.charAt(l) == string.charAt(r)){//两头相等
                sb.append(string.charAt(l));
                sb.append(string.charAt(r));
                l++;r--;
            }
            //不对称
            if(string.charAt(l) == string.charAt(r - 1)){
                r--;
                continue;
            }
            if(string.charAt(l + 1) == string.charAt(r )){
                l++;
                continue;
            }
            if (string.charAt(l + 1) == string.charAt(r - 1)){
                r--;
                l++;
            }
        }
        return sb == null ? "" : sb.toString();
    }
}
