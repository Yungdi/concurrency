package basic.future.complete;

import basic.IterationRunnable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException {
        CompletableFuture<Void> complete = CompletableFuture
                .runAsync(new IterationRunnable(10))
                .thenCompose(aVoid -> CompletableFuture.runAsync(new IterationRunnable(5)))
                .thenAcceptAsync(aVoid -> System.out.println("complete"));
        System.out.println("hello world");
        TimeUnit.SECONDS.sleep(30L);
    }
}
