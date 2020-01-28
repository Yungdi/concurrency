package basic.join;

public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 10; i++) {
                try {
                    System.out.println(i);
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                }
            }
        };
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        thread1.start();
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("end");
    }
}
