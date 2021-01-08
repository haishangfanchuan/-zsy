package multithreading;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author shengyun
 * @date 2020/12/23
 */
public class BlockQueueTest {

    private static final File DUMMY = new File("");
    private static  ArrayBlockingQueue<File> queue = new ArrayBlockingQueue(10);

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入文件绝对路径(E:\\Maven\\repository): ");
        String fileName = scanner.nextLine();

        System.out.println("请输入搜索关键词(.lastUpdated): ");
        String keyWord = scanner.nextLine();

        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 4, 1L, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(512), new ThreadPoolExecutor.AbortPolicy());
        new Thread(() -> {
            try {
                listDirectory(new File(fileName));
                queue.put(DUMMY);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        executor.execute(() -> {
            boolean done = false;
            while (!done) {
                try {
                    File file = queue.take();
                    if (file == DUMMY) {
                        done = true;
                    }else search(file,keyWord);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }


    private static void listDirectory(File file) throws InterruptedException {
        File[] files = file.listFiles();
        if (files == null || files.length == 0) return;
        for (File f : files) {
            if (f.isDirectory()) listDirectory(f);
            else queue.put(f);
        }
    }

    private static void search(File file,String keyWord) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String str;
        int lineNumber = 0;
        while ((str = reader.readLine()) != null) {
            lineNumber++;
            if (str.contains(keyWord)) {
                System.out.println("文件路径: " + file.getPath() + ">>>>> keyWord: " + keyWord + ">>>>>> lineNumber:" + lineNumber);
            }
        }
    }
}
