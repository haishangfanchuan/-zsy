package leetcode.day0628;


import java.util.*;
import java.util.stream.Collectors;

public class LRUCache {

    private int size;
    private int useNum=0;//key使用次数
    private Map<Integer,Integer> map = new  HashMap<>();
    private Map<Integer,Integer> map2 = new  HashMap<>();;//存储key的使用次数

    public LRUCache(int size){
        this.size=size;
    }


    public int put(int key,int value){
        if(map.size()<size){
            //当key不存在就写入
            if(!map.containsKey(key)) {
                map.put(key, value);
                map2.put(key,useNum+1);
                return map.size();
            }
        }
        //如存满就删除一个不常用的
        //map2按照value进行排序
        List<Map.Entry<Integer,Integer>> list = map2.entrySet().stream()
                .sorted((entry1, entry2) -> entry1.getValue().compareTo(entry2.getValue()))
                .collect(Collectors.toList());
        Integer removeKey = list.get(0).getKey();
        map2.remove(removeKey);
        map.remove(removeKey);
        map.put(key,value);
        map2.put(key,useNum+1);

        return map.size();
    }

    public int get(int key ){
        //获得key存在,使用次数+1
        if(map.containsKey(key)){
            Set<Integer> keysSet = map2.keySet();
            Integer knum;
            for(Integer keySet :keysSet){
                   knum = map2.get(keySet);
                   map2.put(key,knum+1);
            }
            return map.get(key);
        }else{
            return -1;
        }
    }

}
