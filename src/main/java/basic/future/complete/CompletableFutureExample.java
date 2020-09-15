package basic.future.complete;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;

public class CompletableFutureExample {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        AtomicInteger a = new AtomicInteger(10);
        CompletableFuture<Void> async1 = CompletableFuture.supplyAsync(a::incrementAndGet)
                .thenAcceptAsync(System.out::println);
        CompletableFuture<Void> async2 = CompletableFuture.supplyAsync(a::incrementAndGet)
                .thenAcceptAsync(System.out::println);
        CompletableFuture.allOf(async1, async2)
                .get();
    }
}
