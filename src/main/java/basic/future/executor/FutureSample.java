package basic.future.executor;

import basic.IterationCallable;

import java.util.Arrays;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Future 은 get() 메소드를 호출할 때 해당 task 가 종료될 때까지 blocking 한다.
 */

public class FutureSample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
//        Future<Void> submit1 = executorService.submit(new IterationCallable(10));
//        Future<Void> submit2 = executorService.submit(new IterationCallable(5));
        executorService.invokeAll(Arrays.asList(new IterationCallable(10), new IterationCallable(5)));
        executorService.shutdown();
        while (!executorService.awaitTermination(1L, TimeUnit.SECONDS))
            System.out.println("not terminated");


    }
}
