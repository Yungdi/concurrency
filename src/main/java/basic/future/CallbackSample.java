package basic.future;

import java.nio.channels.CompletionHandler;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallbackSample {
    public static void main(String[] args) {
        CompletionHandler<Integer, Void> callback = new CompletionHandler<Integer, Void>() {

            @Override
            public void completed(Integer result, Void attachment) {
                System.out.println("완료 callback: " + result);
            }

            @Override
            public void failed(Throwable exc, Void attachment) {
                System.out.println("실패 callback: " + exc.toString());
            }
        };


        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        executorService.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                sum += i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
            callback.completed(sum, null);
        });
        executorService.submit(() -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                sum += i;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ignored) {
                }
            }
            callback.completed(sum, null);
        });
        executorService.shutdown();
    }
}
