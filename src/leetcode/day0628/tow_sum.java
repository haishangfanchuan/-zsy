package leetcode.day0628;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class tow_sum {


    public static void main(String[] args) {
        int[] nums ={1,11,3,4,};
        int[] ints = twoSum(nums, 7);
        System.out.println(ints[0]+"..."+ints[1]);
    }
    public static  int[] twoSum(int[] nums, int target){
        Map<Integer, Integer> map = new HashMap<Integer,Integer>();
        for(int i=0;i<nums.length;i++){
            if(target>nums[i]){
                map.put(i,nums[i]);
            }
        }
        int temp=1;
        Set<Integer> keys = map.keySet();
        Object[] toArray = keys.toArray();
        for(int i =0;i<toArray.length;i++){
            while(i+temp<keys.size()-1){
                temp++;
                if(target==map.get((Integer) toArray[i])+map.get((Integer)toArray[i+temp])) {
                    int[] vector = new int[2];
                    vector[0] =i;
                    vector[1]=i+temp;
                    return vector;
                }
            }
        }
        return null;
    }
}
