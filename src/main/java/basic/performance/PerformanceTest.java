package basic.performance;

import basic.IterationRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class PerformanceTest {
    public static void main(String[] args) throws InterruptedException {
        int availableProcessors = Runtime.getRuntime().availableProcessors() / 4;
        System.out.println(availableProcessors);
        long startTime = System.currentTimeMillis();
        ExecutorService executorService = Executors.newFixedThreadPool(availableProcessors);
        for (int i = 0; i < availableProcessors; i++) {
            executorService.submit(new IterationRunnable(30));
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1L, TimeUnit.SECONDS))
            System.out.println("#### not terminated ####");
        long endTime = System.currentTimeMillis();
        System.out.println("총 걸린 시간: " + (endTime - startTime));
    }
//    public static void main(String[] args) {
//        long startTime = System.currentTimeMillis();
//        for (long j = 0; j < 100_000_000_000L; j++);
//        long endTime = System.currentTimeMillis();
//        System.out.println("총 걸린 시간: " + (endTime - startTime));
//    }
}
