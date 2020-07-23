package leetcode.day0628;


import java.util.Arrays;

public class Demo01 {

    public static void main(String[] args) {
        Demo01 demo01 = new Demo01();
        int[] a = {1,2,3,4,5};
        int[] b = {6,7,8,9};
        int[] ints = demo01.method01(a, b);
        for (int i = 0; i <ints.length ; i++) {
            System.out.println(ints[i]);
        }
    }


    public int[] method01(int[] a,int [] b) {

        int[] arry = new int[a.length+b.length];
        for (int i = 0; i <a.length ; i++) {
            arry[i]=a[i];
        }
        for (int i = 0; i < b.length; i++) {
            arry[a.length+i]=b[i];
        }
        Arrays.sort(arry);
       return arry;
    }
}
