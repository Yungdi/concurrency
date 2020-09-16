package chapter7;

import java.time.LocalDateTime;
import java.util.concurrent.TimeUnit;

public class InterruptedStatusTest {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            System.out.println(LocalDateTime.now());
            for (long i = 0; i < 5_000_000_000L; i++) {
            }
            System.out.println(LocalDateTime.now());
            try {
                System.out.println(Thread.currentThread().isInterrupted());
                TimeUnit.SECONDS.sleep(1L);
            } catch (InterruptedException e) {
                System.out.println(LocalDateTime.now());
                System.out.println(Thread.currentThread().isInterrupted());
            }
        });
        thread.start();
        thread.interrupt();
    }
}