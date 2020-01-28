package cucurrency.chapter3.syncronization.thread_reference;

public class Counter {
    private int c = 0;

    public void increment() {
        c++;
    }

    public void decrement() {
        c--;
    }

    public int value() {
        return this.c;
    }

}
