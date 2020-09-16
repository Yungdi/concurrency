package chapter7;

import java.util.concurrent.TimeUnit;

public class InterruptionEx {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            int i = 0;
            Thread currentThread = Thread.currentThread();
            while (!currentThread.isInterrupted()) {
                for (long j = 0; j < 10_000_000_000L; j++) {
                }
                System.out.println(++i);
            }
        });
        thread.start();
        TimeUnit.SECONDS.sleep(10L);
        System.out.println(thread.isInterrupted());
        thread.interrupt();

        System.out.println(thread.isInterrupted());
    }
}
