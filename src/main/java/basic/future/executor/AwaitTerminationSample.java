package basic.future.executor;

import basic.IterationRunnable;

import java.util.concurrent.*;

public class AwaitTerminationSample {
    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        /*List<IterationCallable> iterationCallable =
                Arrays.asList(new IterationCallable(10),
                        new IterationCallable(10),
                        new IterationCallable(10),
                        new IterationCallable(10),
                        new IterationCallable(5));
        try {
            executorService.invokeAll(iterationCallable);
        } catch (InterruptedException e) {
            System.out.println(e.toString());
        }*/
        executorService.submit(new IterationRunnable(10));
        executorService.submit(new IterationRunnable(5));

        executorService.shutdown();
        // 1초 이후부터 시작함
        while (!executorService.awaitTermination(1, TimeUnit.SECONDS)) {
            System.out.println("not terminated");
        }
//        while (!executorService.isTerminated()) {
//            System.out.println("not terminated");
//            TimeUnit.SECONDS.sleep(1L);
//        }

    }
}
