package basic.lock;

public class LockTest {

    public static void main(String[] args) {
        Object object = new Object();
        Thread thread1 = new Thread(LockTest::test);
        Thread thread2 = new Thread(() -> {
            synchronized (object) {
                System.out.println("obj start");
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                }
                System.out.println("object");
            }
        });
        thread1.start();
        thread2.start();
    }

    synchronized static void test() {
        System.out.println("test start");
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
        }
        System.out.println("test");
    }

}