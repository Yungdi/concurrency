package basic.pool;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

public class PoolSample {
    public static void main(String[] args) throws InterruptedException {
        final int nThreads = Runtime.getRuntime().availableProcessors();
        ExecutorService executorService = Executors.newFixedThreadPool(nThreads);
        executorService.execute(() -> System.out.println(nThreads));
        boolean isTermination = executorService.awaitTermination(1, TimeUnit.SECONDS);
        System.out.println(isTermination);

        List<Runnable> list = executorService.shutdownNow();

        ExecutorService executorService1 =
                new ThreadPoolExecutor(4, 100, 120L, TimeUnit.SECONDS, new SynchronousQueue<>());
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();

        Set<Thread> threads = allStackTraces.keySet();
        threads.forEach(thread ->
                System.out.println("Name: " + thread.getName() + ", isDaemon: " + thread.isDaemon() + ", Group: " + thread.getThreadGroup().getName()));
    }
}
