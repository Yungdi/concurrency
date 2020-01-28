package cucurrency.chapter6.guarded_blocks.ex;

public class Deposit implements Runnable {
    private final Bank bank;

    public Deposit(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (bank.getBalance() < 100)
            bank.put();
    }

}
