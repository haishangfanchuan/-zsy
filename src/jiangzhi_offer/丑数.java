package jiangzhi_offer;

/**
 * @author zhangsy
 * @date 2020/9/23 23:39
 */
public class 丑数 {

    public static void main(String[] args) {
        丑数 c = new 丑数();
        System.out.println(c.GetUglyNumber_Solution(7));
    }

    public int GetUglyNumber_Solution(int index) {

        if (index == 1) return 1;
        int num =  1 , res = 1;
        while(res < index){
            if (num % 2 !=0 || num % 3 !=0 || num % 5 !=0)  {
                num ++;continue;
            }
            if(isUglyNumber(num)){
                num++;res++;
            }else num++;
        }
        return num;
    }

    private boolean isUglyNumber(int num){
        if (num % 2 !=0 || num % 3 !=0 || num % 5 !=0)  return false;
        for (int i = 2; i< num; i++) {
            if (i!=2 && i!=3 && i!=5 && num % i ==0)  return false;
        }
        return true;
    }
}
