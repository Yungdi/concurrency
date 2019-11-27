import org.junit.Test;

public class SimpleTest {

    @Test
    public void test() {
        Thread thread = new Thread(() -> System.out.println(Thread.currentThread().isAlive()));
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
        } finally {
            System.out.println(thread.isAlive());
        }
    }

}
