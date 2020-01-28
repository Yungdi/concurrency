package basic.future.executor;

import basic.IterationCallable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * invokeAll 은 모든 task 가 종료될 때 까지 blocking 한다.
 */
public class InvokeAllSample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        List<IterationCallable> list = Arrays.asList(new IterationCallable(10), new IterationCallable(5));
        try {
            executorService.invokeAll(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
        while (!executorService.awaitTermination(1L, TimeUnit.SECONDS)) {
            System.out.println("not terminated");
        }
    }
}
