package web;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author shengyun
 * @date 2020/12/17
 */
public class SocketTest2 {
    public static void main(String[] args) {
        try {
            Socket socket = new Socket("time-a.nist.gov",13);
            InputStream inputStream = socket.getInputStream();
            int read = inputStream.read();
            System.out.println((byte)read);
            Scanner scanner = new Scanner(inputStream, "UTF-8");
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Test2{
    public static void main(String[] args) throws IOException {
        String property = System.getProperty("user.dir");
        File file = new File(property + "/test.txt");
        FileInputStream inputStream = new FileInputStream(file);
        BufferedInputStream stream = new BufferedInputStream(inputStream);
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
        while (bufferedReader.readLine()!=null) {
            System.out.println(bufferedReader.readLine());
        }
        try {
            int b;
            byte[] bytes = new byte[1024];
            if ( (b = inputStream.read(bytes)) != -1) {
                System.out.print(new String(bytes,0,b));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            inputStream.close();
        }
    }
}


class SocketServer {
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, 4, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<>(512),new ThreadPoolExecutor.AbortPolicy());
        threadPoolExecutor.execute(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8080);
                Socket accept = serverSocket.accept();
                OutputStream outputStream = accept.getOutputStream();
                InputStream inputStream = accept.getInputStream();
                Scanner scanner = new Scanner(inputStream, "UTF-8");
                PrintWriter writer = new PrintWriter(new OutputStreamWriter(outputStream), true);
                writer.println("hello ... enter bye to exit");
                Scanner s = new Scanner(System.in);
                boolean flag = true;
                while (flag && scanner.hasNext()) {
                    String str = scanner.next();

                    writer.println(str);
                    if ("bye".equalsIgnoreCase(str)) flag = false;
                }
                outputStream.close();
                inputStream.close();
                writer.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}

class SocketClient {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
//        InetAddress localAddress = socket.getLocalAddress();
//        socket.connect(new InetSocketAddress(localAddress,8089));
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(outputStream),true);
        Scanner scanner = new Scanner(inputStream,"UTF-8");
        Scanner s = new Scanner(System.in);
        printWriter.println(s.next());
        while (scanner.hasNext()) {
            System.out.println(scanner.nextLine());
        }
    }
}

class Test3{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(next);
    }
}
