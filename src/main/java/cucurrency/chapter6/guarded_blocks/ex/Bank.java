package cucurrency.chapter6.guarded_blocks.ex;

public class Bank {
    private int balance = 0;
    private boolean check = true;

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void put() {
        if (!check) {
            try {
                System.out.println(Thread.currentThread().toString() + "waiting");
                wait();
            } catch (InterruptedException e) {
            }
        }
        check = false;
        balance += 20;
        System.out.println(Thread.currentThread().toString() + ": " + balance);
        if (balance >= 100)
            System.exit(-1);
        else
            notifyAll();

    }

    public synchronized void take() {
        if (check) {
            try {
                System.out.println(Thread.currentThread().toString() + "waiting");
                wait();
            } catch (InterruptedException e) {
            }
        }
        check = true;
        balance -= 10;
        System.out.println(Thread.currentThread().toString() + ": " + balance);
        notifyAll();
    }

}