package top.theonecyl.datastructrue.hensheng;

public class HsTest01 {
    public static void main(String[] args) {

        int temp = 0;
        for (int i = 1; i <10 ; i++) {
            for (int j = i+1; j < 10; j++) {
                for (int k = j+1; k < 10 ; k++) {
                    if((i+j+k)%2==0){
                        temp+=1;
                    }
                }
            }
        }
        System.out.println(temp);
    }
}
