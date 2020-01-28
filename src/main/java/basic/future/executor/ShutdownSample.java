package basic.future.executor;

import basic.IterationRunnable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;

public class ShutdownSample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.submit(new IterationRunnable(10));
        executorService.submit(new IterationRunnable(5));
        executorService.shutdown();
        try {
            executorService.submit(new IterationRunnable(5));
        } catch (RejectedExecutionException e) {
            System.out.println(e.toString());
        }
    }

}