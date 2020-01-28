package cucurrency.chapter1.process_and_threads;

public class Test {

    public synchronized void lock() {
        System.out.println("hello");
        try {
            wait();
        } catch (InterruptedException e) {
        }
        System.out.println("world");
    }

    public synchronized void release() {
        notify();
    }

    public static void main(String[] args) throws Exception {
        Test test = new Test();
        Thread thread = new Thread(() -> test.lock());
        thread.start();

        Thread.sleep(3000);
        synchronized (test) {
            test.notify();
        }


//        Thread thread1 = new Thread(() -> test.release());
//        thread1.start();
    }
}
