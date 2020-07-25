package top.theonecyl.datastructrue.BinarySearch;


import java.util.ArrayList;
import java.util.List;

/**
 * 二分查找
 */
public class BinaryDemo1 {

    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5,7,9,11,11,13,15,19,19,19,19};
        System.out.println(getNumAllIndex(nums,0,nums.length,-1));
    }

    //查找有序数组中某个数的下标，没有放回-1
    public static int getNumIndex(int[] array,int left ,int right,int targetNum){
        int mid = (left+right)/2;

        //退出递归，返回结果
        if(left>right){
            return -1;
        }
        if(targetNum>array[mid]){
            //先右边查询
            return getNumIndex(array,mid+1,right,targetNum);
        }else if(targetNum<array[mid]){
            //先左边查询
            return getNumIndex(array,left,mid-1,targetNum);
        }else {
            return mid;
        }
    }

    //找出数组中重复出现的元素
    public static List<Integer> getNumAllIndex(int[] array, int left , int right, int targetNum){
        int mid = (left+right)/2;

        //退出递归，返回结果
        if(left>right){
            return null;
        }
        if(targetNum>array[mid]){
            //先右边查询
            return getNumAllIndex(array,mid+1,right,targetNum);
        }else if(targetNum<array[mid]){
            //先左边查询
            return getNumAllIndex(array,left,mid-1,targetNum);
        }else {
            //找到了数，判断其是否重复出现
            list.add(mid);
            int index = 1;
            if(mid+1<array.length) {
                //存在重符
                //右侧扫描
                while (array[mid + index] == targetNum) {
                    list.add(mid + index);
                    index++;
                    if (mid + index >= array.length) {
                        index = 1;
                        break;
                    }
                }
            }
            //左侧扫描
            if(mid-1>=0) {
                while (array[mid - index] == targetNum) {
                    list.add(mid - index);
                    index++;
                    if (mid - index < 0) {
                        index = 1;
                        break;
                    }
                }
            }
            return list;
        }
    }
}
