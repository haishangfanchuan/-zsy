package jiangzhi_offer;

/**
 * @author zhangsy
 * @date 2020/9/17 13:34
 */
public class 变态跳台阶 {

    public static void main(String[] args) {
        System.out.println(JumpFloorII(3));
    }

    public static int JumpFloorII(int target) {
        if(target == 1) return 1;
        if(target == 2)return 2;
        int res = 1 , pre = 2;
        for (int i = 3; i <= target; i++) {
            res = pre * 2;
            pre  = res;
        }
        return res;
    }
}
