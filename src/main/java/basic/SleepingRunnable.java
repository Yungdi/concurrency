package basic;

import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

public class SleepingRunnable implements Runnable {
    private final int ITERATION_COUNT;

    public SleepingRunnable(int count) {
        this.ITERATION_COUNT = count;
    }

    @Override
    public void run() {
        for (int i = 1; i <= ITERATION_COUNT; i++) {
            System.out.println(Thread.currentThread().getName() + ": " + i);
            try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException ignored) {
            }
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IterationRunnable.class.getSimpleName() + "[", "]")
                .add("ITERATION_COUNT=" + ITERATION_COUNT)
                .toString();
    }
}
