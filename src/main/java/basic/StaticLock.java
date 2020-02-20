package basic;

public class StaticLock {

    public synchronized static void test() {
        System.out.println(Thread.currentThread() + ": lock acquire");
        for (int i = 0; i < 1_000_000_000; i++) {

        }
        System.out.println(Thread.currentThread() + ": lock release");
    }

    public static void main(String[] args) {
        Thread thread1 = new Thread(StaticLock::test);
        Thread thread2 = new Thread(StaticLock::test);
        thread1.start();
        thread2.start();
    }

}
