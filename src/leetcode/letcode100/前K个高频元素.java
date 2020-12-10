package leetcode.letcode100;

/**
 * @author zhangsy
 * @date 2020/9/7 17:11
 */

import java.util.*;

/**
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。

 示例 1:

 输入: nums = [1,1,1,2,2,3], k = 2
 输出: [1,2]
 示例 2:

 输入: nums = [1], k = 1
 输出: [1]

 */
public class 前K个高频元素 {

    public static void main(String[] args) {
        //[4,1,-1,2,-1,2,3]
        //2
        int[] array = {4,1,-1,2,-1,2,3};
        System.out.println(Arrays.toString(topKFrequent(array,2)));
    }

    public static int[] topKFrequent(int[] nums, int k) {
        if(nums==null || nums.length<k) return new int[0];
        if(nums.length==k) return nums;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if(map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }
            else map.put(num,1);
        }
        Map<Integer, Integer> sort = sortByValue(map);
        System.out.println(sort);
        int[] ints = new int[k];
        Set<Integer> keys = sort.keySet();
        int count = 0,index = 0;
        for(Integer key : keys){
            if(count>=map.size()-k){
                ints[index] = key;
                index++;
            }
            count++;
        }
        return ints;
    }
    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.comparingByValue());

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }

        return result;
    }
}
