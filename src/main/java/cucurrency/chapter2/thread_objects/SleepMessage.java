package cucurrency.chapter2.thread_objects;

public class SleepMessage {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String importantInfo[] = {
                    "Mares eat oats",
                    "Does eat oats",
                    "Little lambs eat ivy",
                    "A kid will eat ivy too"
            };

            for (int i = 0; i < importantInfo.length; i++) {
                try {
                    System.out.println(importantInfo[i]);
                    Thread.sleep(4000);
                } catch (InterruptedException e) {
                    System.out.println("interrupted");
                    return;
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }
}
