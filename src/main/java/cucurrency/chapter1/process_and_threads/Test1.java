package cucurrency.chapter1.process_and_threads;

public class Test1 {

    synchronized void test() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            print();
        }
    }

    synchronized void print() {
        System.out.println("hello world");
    }

    public static void main(String[] args) {
        Test1 test1 = new Test1();
        new Thread(test1::test).start();
    }
}
