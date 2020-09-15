package basic.future;

import java.util.concurrent.*;

public class InterruptionSample {

    public static void main(String[] args) {
        BlockingQueue<Runnable> a = new LinkedBlockingQueue<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 1000L, TimeUnit.DAYS, a);
        threadPoolExecutor.submit(() -> {
            Thread thread = Thread.currentThread();
            thread.interrupt();
            System.out.println("hello world");
        });
    }
}
