package reviewIO;

import java.io.*;
import java.util.HashSet;

/**
 * @author zhangsy
 * @date 2020/9/8 15:26
 */
public class ReviewIoDemo01 {

    public static void main(String[] args) throws IOException {
        InputStreamReader stream = new InputStreamReader(new FileInputStream("C:\\Users\\zhangyushizhu\\Desktop\\Hello.txt"));
        BufferedReader bufferedReader = new BufferedReader(stream);
        BufferedWriter outputStreamWriter = new BufferedWriter(new FileWriter("C:\\Users\\zhangyushizhu\\Desktop\\Hello2.txt"));

//        new BufferedOutputStream(new FileOutputStream(""));

        String string;
        while ((string=bufferedReader.readLine())!=null){
            outputStreamWriter.write(string);
            System.out.println(string);
        }

        HashSet<Integer> integers = new HashSet<>();
        integers.add(null);
        System.out.println(integers+"哈哈");
    }
}
