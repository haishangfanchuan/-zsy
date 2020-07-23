package top.theonecyl.datastructrue.recursion;

/**
 * 八皇后问题
 */
public class Queen8 {
    private static int queenNum = 8;
    private static int[] array = new int[queenNum];
    private static int count = 0;
    private static int temp = 0;
    public static void main(String[] args) {
        check(0);
        System.out.println("一共有多少可能："+count);
        System.out.println("一共检测冲突多少次："+temp);
    }


    private static void check(int n){
        if(n==queenNum){
            print();
            return;
        }
        for (int i = 0; i <array.length ; i++) {
            //从第一列开始匹配
            array[n] = i;
            if(isConflict(n)){
                check(n+1);
            }
        }
    }

    //判断是否会与之前的皇后发生冲突
    //1、不能再同一列，2、不能再同一条斜线上
    private static boolean isConflict(int n){
        temp++;
        for (int i = 0; i <n ; i++) {
            if(array[i]==array[n] || Math.abs(n-i)==Math.abs(array[n] - array[i])){
                return false;
            }
        }
        return true;
    }

    //打印匹配的数组
    private static void print(){
        count++;
        for (int i = 0; i <array.length ; i++) {
            System.out.print(array[i]+ " ");
        }
        System.out.println();
    }
}
