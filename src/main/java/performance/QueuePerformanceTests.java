package performance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class QueuePerformanceTests {


    public static void main(String[] args) throws InterruptedException {
        final int COUNT = 64_000_000;
        long startTime = System.currentTimeMillis();
        BlockingQueue<PidRange> blockingQueue = new LinkedBlockingQueue<>();
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Callable<Void> addRunnable = () -> {
            for (int i = 0; i < COUNT; i++)
                blockingQueue.add(new PidRange());
            return null;
        };
        Callable<Void> takeRunnable = () -> {
            for (int i = 0; i < COUNT; i++) {
                try {
                    blockingQueue.take();
                } catch (InterruptedException ignored) {
                }
            }
            return null;
        };
        List<Callable<Void>> tasks = Arrays.asList(addRunnable, takeRunnable);
        executorService.invokeAll(tasks);
        executorService.shutdown();
        long endTime = System.currentTimeMillis();
        //17272, 10910
        System.out.println(blockingQueue.size() + " " + (endTime - startTime));
    }
}
