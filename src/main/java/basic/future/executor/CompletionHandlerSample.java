package basic.future.executor;

import java.nio.channels.CompletionHandler;
import java.time.LocalTime;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CompletionHandlerSample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        CompletionHandler<Integer, Void> completionHandler = new CompletionHandler<Integer, Void>() {
            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println(Thread.currentThread().getName() + LocalTime.now() + "result: " + result);
                System.out.println(result);
            }

            @Override
            public void failed(Throwable exc, Void attachment) {

            }
        };
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    completionHandler.failed(e, null);
                }
            }
            completionHandler.completed(sum, null);
        });
        executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + System.currentTimeMillis());
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
                try {
                    TimeUnit.SECONDS.sleep(1L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    completionHandler.failed(e, null);
                }
            }
            completionHandler.completed(sum, null);
        });
        executorService.shutdown();
    }
}
