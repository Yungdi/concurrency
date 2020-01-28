package basic.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultSample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        Runnable runnable = () -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
            }
            System.out.println(sum);
        };
        Future<?> submit = executorService.submit(runnable);

        try {
            submit.get();
        } catch (InterruptedException | ExecutionException ignored) {
        }
        executorService.shutdown();
    }
}
