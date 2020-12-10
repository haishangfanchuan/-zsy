package jiangzhi_offer;

/**
 * @author zhangsy
 * @date 2020/9/18 16:42
 */
public class N个房间N把钥匙 {

    public static void main(String[] args) {
        System.out.println(method(3));
    }

    //求旅客拿错钥匙的可能情况有几种
    public static int method(int n){
        if(n==1) return 0;
        if(n==2)return 1;
        else return  (n - 1) * (method(n -1 ) + method(n -2));
//        int pre1 = 0, pre2 = 1,res = 0;
//        for (int i = 3; i <= n; i++) {
//            res = (i -1)*(pre1 + pre2);
//            pre1 = pre2;
//            pre2 = res;
//        }
//        return res;


    }


}
