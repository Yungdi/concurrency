package basic;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

public class IterationCallable implements Callable<Integer> {
    private final int ITERATION_COUNT;

    public IterationCallable(int count) {
        ITERATION_COUNT = count;
    }

    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 1; i <= ITERATION_COUNT; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            sum += i;
            TimeUnit.SECONDS.sleep(1L);
        }
        return sum;
    }

}
