package jiangzhi_offer;

/**
 * @author zhangsy
 * @date 2020/9/16 23:44
 *
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。
 * 例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 */
public class 替换空格 {

    public static void main(String[] args) {
        System.out.println(replaceSpace(new StringBuffer("We Are Happy.")));

        ThreadLocal<String> local = new ThreadLocal<>();
        Thread thread = new Thread();

    }

    public static String replaceSpace(StringBuffer str) {
        return str.toString().replace(" ","%20");
    }
}

class TestA{

}
