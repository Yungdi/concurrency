package basic.future;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MultiFuture {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> runnable1 = () -> {
            int sum = 0;
            for (int i = 1; i <= 15; i++) {
                try {
                    Thread.sleep(1000);
                    sum += i;
                } catch (InterruptedException ignored) {
                }
            }
            System.out.println("runnable1 is completed");
            return sum;
        };
        Callable<Integer> runnable2 = () -> {
            int sum = 0;
            for (int i = 1; i <= 5; i++) {
                try {
                    Thread.sleep(1000);
                    sum += i;
                } catch (InterruptedException ignored) {
                }
            }
            System.out.println("runnable2 is completed");
            return sum;
        };
        List<Callable<Integer>> tasks = new ArrayList<>();
        tasks.add(runnable1);
        tasks.add(runnable2);
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Future<Integer>> futures = executorService.invokeAll(tasks);
        for (Future<Integer> future : futures) {
            System.out.println(future.get());
        }
        // 작업은 runnable2 가 먼저 끝나지만 runnable1 에 대한 결과값을 먼저 get 했기 때문에
        // runnable1이 끝날 때까지 runnable2가 값을 반환하지 못함
        executorService.shutdown();
    }
}
