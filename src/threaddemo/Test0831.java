package threaddemo;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Test0831 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 3, 0
                , TimeUnit.MILLISECONDS, new LinkedBlockingDeque<>(512), new ThreadPoolExecutor.DiscardPolicy());
        executor.execute(new Runnable() {
            @Override
            public void run() {

            }
        });
        executor.shutdownNow();
    }
}
