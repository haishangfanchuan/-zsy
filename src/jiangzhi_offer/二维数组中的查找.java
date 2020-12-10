package jiangzhi_offer;

/**
 * @author zhangsy
 * @date 2020/9/16 23:13
 *
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class 二维数组中的查找 {

    public static void main(String[] args) {
//        int[][] array = {
//                {1,4,7,11,15},
//        {2,5,8,12,19 },
//        {3,6,9,16,22 },
//        {10,13,14,17,24},
//        {18,21,23,26,30}
//        };
        int[][] array = {{1,3,5}};
        System.out.println(Find(3,array));
    }

    public static boolean Find(int target, int [][] array) {
        if(array==null || array.length==0 || array[0].length==0) return false;
        int len = array.length;
        int lenEnd = array[0].length;
        if(array[0][0] > target) return false; //target小于第一个数，false
        for (int i = 0; i < len; i++) {

            if(array[i][0] <= target && target <= array[i][lenEnd -1]) {
                if(array[i][0] == target || target == array[i][lenEnd -1])
                    return true;
                //可能会存在此数，二分查找
                int start = 0 , end = lenEnd - 1 , mid = (start + end) >> 1;
                while (start<=end) {
                    if(array[i][mid] == target) return true;
                    if(array[i][mid] > target) {//向左搜索
                        end = mid - 1;
                        mid = (start + end) >> 1;
                    }else if(array[i][mid] < target){ //向右搜索
                        start = mid + 1;
                        mid = (start + end) >> 1;
                    }
                }
            }
        }
        return false;
    }
}
