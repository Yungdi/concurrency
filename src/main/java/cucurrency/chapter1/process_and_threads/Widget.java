package cucurrency.chapter1.process_and_threads;

public class Widget {

    public synchronized void doSomething() {
        System.out.println("widget");
    }
}
