package basic.future;

import basic.IterationCallable;

import java.util.concurrent.*;

public class CompletionServiceSample {
    public static void main(String[] args) {
        ExecutorService pool = Executors.newFixedThreadPool(2);
        ExecutorService nextPool = Executors.newFixedThreadPool(2);

        CompletionService<Integer> completionService = new ExecutorCompletionService<>(pool);
        completionService.submit(new IterationCallable(10));
        completionService.submit(new IterationCallable(5));
        pool.shutdown();
        while (!pool.isTerminated()) {
            System.out.println("not terminated!");
            try {
                // take(): 어느 하나 작업이 끝날 때까지 블라킹 상태
                Future<Integer> future = completionService.take();
                Integer sum = future.get();
                System.out.println(sum);
                nextPool.submit(new MultiplicationCallable(sum));
            } catch (InterruptedException | ExecutionException ignored) {
            }
        }
        nextPool.shutdown();
    }
}