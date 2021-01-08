package java8;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @author shengyun
 * @date 2020/12/10
 */
public class FileStream {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("E:\\JDK\\jdk_8\\src.zip");
        BufferedInputStream stream = new BufferedInputStream(Files.newInputStream(path));
        FileChannel channel = FileChannel.open(path);
        ByteBuffer buffer = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
        int b;
        while (buffer.hasRemaining()) {
            char b1 =(char ) buffer.get();
            System.out.println(b1);
        }
    }
}
