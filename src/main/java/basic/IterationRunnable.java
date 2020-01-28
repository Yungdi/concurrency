package basic;

import java.util.StringJoiner;

public class IterationRunnable implements Runnable {
    private final int ITERATION_COUNT;

    public IterationRunnable(int count) {
        this.ITERATION_COUNT = count;
    }

    @Override
    public void run() {
        for (long j = 0; j < 100_000_000_000L; j++);
        System.out.println(Thread.currentThread().getName() + " is end");
//        for (int i = 1; i <= ITERATION_COUNT; i++) {
//            System.out.println(Thread.currentThread().getName() + ": " + i);
            /*try {
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException ignored) {
            }*/
//        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", IterationRunnable.class.getSimpleName() + "[", "]")
                .add("ITERATION_COUNT=" + ITERATION_COUNT)
                .toString();
    }
}