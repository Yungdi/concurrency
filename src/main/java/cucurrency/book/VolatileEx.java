package cucurrency.book;

public class VolatileEx {
    private volatile long count;

    public synchronized void add() {
        this.count++;
    }

    public long get() {
        return this.count;
    }

}