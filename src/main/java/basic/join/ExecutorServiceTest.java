package basic.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceTest {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable<Integer> callable = () -> {
            System.out.println("덧셈 시작");
            int sum = 0;
            for (int i = 1; i <= 10; i++) {
                try {
                    sum += i;
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
            System.out.println("덧셈 끝");
            return sum;
        };
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        Future<Integer> submit1 = executorService.submit(callable);
        Future<Integer> submit2 = executorService.submit(callable);
        Thread.sleep(5000L);
        System.out.println("get 시작");
        Integer sum1 = submit1.get();
        Integer sum2 = submit2.get();
        System.out.println(sum1 + sum2);
        System.out.println("get 끝");
        executorService.shutdown();
    }
}
