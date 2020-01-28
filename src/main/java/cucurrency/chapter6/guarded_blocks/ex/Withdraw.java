package cucurrency.chapter6.guarded_blocks.ex;

public class Withdraw implements Runnable {
    private final Bank bank;

    public Withdraw(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (bank.getBalance() < 100)
            bank.take();
    }
}
