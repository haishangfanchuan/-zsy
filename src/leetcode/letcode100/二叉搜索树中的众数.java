package leetcode.letcode100;

import leetcode.letcode100.comment.TreeNode;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.*;

/**
 * @author zhangsy
 * @date 2020/9/24 16:53
 */
public class 二叉搜索树中的众数 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        root.right = right;
        right.left = left;
        二叉搜索树中的众数 c = new 二叉搜索树中的众数();
        System.out.println(Arrays.toString(c.findMode(root)));
    }


    public int[] findMode(TreeNode root) {
        if(root==null) return new int[]{};
        int[] res = new int[1];
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, Integer> mapFun = fun(map, root);
        Set<Integer> keys = map.keySet();
        int max = 0;
        for (Integer key : keys) {
            max = Math.max(max,mapFun.get(key));
        }
        List<Integer> list = new ArrayList<>();
        for (Integer key : keys) {
            if(map.get(key)==max){
                if(!list.contains(key)) list.add(key);
            }
        }
        return listToArray(list);
    }

    private Map<Integer,Integer> fun(Map<Integer, Integer> map,TreeNode root){
        if (map.containsKey(root.val))
            map.put(root.val, map.get(root.val) + 1);
        else map.put(root.val ,1);
        if (root.left != null) fun(map,root.left);
        if (root.right != null) fun(map,root.right);
        return map;
    }
    private int[] listToArray(List<Integer> list){
        int[] ints = new int[list.size()];
        int i = 0;
        for (Integer anInt : list) {
            ints[i] = anInt;
            i++;
        }
        return ints;
    }
}
