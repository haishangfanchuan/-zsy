package leetcode.day0629;


import java.util.*;
import java.util.stream.Collectors;

/**
 * 今天，书店老板有一家店打算试营业 customers.length 分钟。每分钟都有一些顾客（customers[i]）会进入书店，
 * 所有这些顾客都会在那一分钟结束后离开。
 在某些时候，书店老板会生气。 如果书店老板在第 i 分钟生气，那么 grumpy[i] = 1，否则 grumpy[i] = 0。
 当书店老板生气时，那一分钟的顾客就会不满意，不生气则他们是满意的。
 书店老板知道一个秘密技巧，能抑制自己的情绪，可以让自己连续 X 分钟不生气，但却只能使用一次。
 请你返回这一天营业下来，最多有多少客户能够感到满意的数量。

 输入：customers = [1,0,1,2,1,1,7,5], grumpy = [0,1,0,1,0,1,0,1], X = 3
 输出：16
 解释：
 书店老板在最后 3 分钟保持冷静。
 感到满意的最大客户数量 = 1 + 1 + 1 + 1 + 7 + 5 = 16.

 */
public class 爱生气的书店老板 {

    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5};
        int[] grumpy =    {0,1,0,1,0,1,0,1};
        爱生气的书店老板 s = new 爱生气的书店老板();
        int i = s.maxSatisfied(customers, grumpy, 3);
        System.out.println(i);

    }

    public int maxSatisfied(int[] customers, int[] grumpy, int X) {

        if(X>=customers.length){
            int count=0;
            for (int i = 0; i <customers.length ; i++) {
                count+=customers[i];
            }
            return count;
        }
        //求出本来就满意的顾客数
        int count=0;
        int temp=0;
        int[] array = new int[customers.length];
        for (int i = 0; i <customers.length ; i++) {
            if(grumpy[i]==0){
                count+=customers[i];
            }
            //遇到生气的顾客开始判断
            if(grumpy[i]==1){
                int num = 0;
                for (int j = 0; j <X ; j++) {
                    if(i+j>=customers.length){
                        break;
                    }
                    //统计X范围内不满意顾客数量
                    num+=customers[i+j];
                    //减去满意的顾客
                    if(grumpy[i+j]==0){
                        num-=customers[i+j];
                    }
                }
                array[temp]=num;
                temp++;
            }
        }
        Arrays.sort(array);
        return count+array[array.length-1];
    }
}
