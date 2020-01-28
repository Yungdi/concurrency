package cucurrency.chapter6.guarded_blocks;

public class Drop {
    // Message sent from producer
    // to consumer.
    private String message;
    // True if consumer should wait
    // for producer to send message,
    // false if producer should wait for
    // consumer to retrieve message.
    private boolean empty = true;

    public synchronized void put(String message) {
        System.out.println("thread: " + Thread.currentThread() + " <put start>");
        // Wait until message has
        // been retrieved.
        while (!empty) {
            try {
                System.out.println("thread: " + Thread.currentThread() + " <waiting>");
                wait();
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            }
        }
        // Toggle status.
        empty = false;
        // Store message.
        this.message = message;
        // Notify consumer that status
        // has changed.
        System.out.println("thread: " + Thread.currentThread() + " <put end>");
        notifyAll();
    }

    public synchronized String take() {
        System.out.println("thread: " + Thread.currentThread() + " <take start>");
        // Wait until message is
        // available.
        while (empty) {
            try {
                System.out.println("thread: " + Thread.currentThread() + " <waiting>");
                wait();
            } catch (InterruptedException e) {
                System.out.println("interrupted!");
            }
        }
        // Toggle status.
        empty = true;
        // Notify producer that
        // status has changed.
        System.out.println("thread: " + Thread.currentThread() + " <take end>");
        notifyAll();
        return message;
    }

}
