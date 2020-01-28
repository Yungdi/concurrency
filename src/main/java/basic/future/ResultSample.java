package basic.future;

import java.util.concurrent.*;

public class ResultSample {
    public static void main(String[] args) {
        Callable<Integer> callable = () -> {
            Thread.sleep(5000L);
            return 5;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> submit = executorService.submit(callable);
        System.out.println("get() start");
        try {
            Integer integer = submit.get();
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        executorService.shutdown();
    }
}
