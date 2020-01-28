package basic;

public class ThreadSample {
    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                System.out.println(Thread.currentThread().getName());
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.setName("myThread");
        thread.start();
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            Thread.sleep(5000);
        }
        Thread thread1 = new Thread();
        thread1.start();

        // 1. Thread 상속
        // 2. Thread 생성(Runnable r)
        // thread 객체 생성 시 runnable 전달 안했을 경우 아무행동도 하지 않음
        // Thread 클래스의 run 을 override 하거나 target:Runnable 을 전달한다.

    }
}
