package top.theonecyl.datastructrue.sort;

/**
 * 冒泡排序
 */
public class BubblingSort {
    public static void main(String[] args) {
        int[] array = new int[]{10,1,35,61,89,36,55};
//        bubblingSort(array);
        recuBubbSort(array,array.length);
        print(array);

    }

    private static int[] bubblingSort(int[] array){
        //从小到大排序，每一个泡泡与他之前的进行比较，如果更大就交换值和位置
        //总共需要排序array.length-1次
        //第i次排序需要比较array.length-1-i次
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j <array.length-i-1; j++) {
               if(array[j]>array[j+1]){
                  int temp;
                  temp = array[j];
                  array[j] = array[j+1];
                  array[j+1] = temp;
               }
            }
        }
        return array;
    }

    private static void print(int[] array){
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " ");
        }
    }

    private static int[] recuBubbSort(int[] array,int temp){
        if(temp==0){
            return array;
        }else {
            //每次需要比较array.length-1次
            for (int i = 0; i < temp - 1 ; i++) {
                if (array[i] > array[i + 1]) {
                    int b;
                    b = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = b;
                }

            }
            temp--;
            recuBubbSort(array,temp);
        }
        return array;
    }
}
