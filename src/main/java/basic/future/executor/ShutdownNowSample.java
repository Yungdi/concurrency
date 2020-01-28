package basic.future.executor;

import basic.IterationRunnable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ShutdownNowSample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.submit(new IterationRunnable(10));
        executorService.submit(new IterationRunnable(5));
        executorService.submit(new IterationRunnable(5));
        executorService.submit(new IterationRunnable(5));
        executorService.submit(new IterationRunnable(5));
        executorService.submit(new IterationRunnable(5));
        executorService.submit(new IterationRunnable(5));
        executorService.submit(new IterationRunnable(5));
        executorService.submit(new IterationRunnable(5));
        List<Runnable> list = executorService.shutdownNow();
        System.out.println(list.toString());
    }
}
