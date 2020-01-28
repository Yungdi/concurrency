package cucurrency.chapter6.guarded_blocks.ex;

public class BankMain {
    public static void main(String[] args) {
        Bank bank = new Bank();
        Thread thread = new Thread(new Deposit(bank));
        thread.setName("Deposit");
        thread.start();
        Thread thread1 = new Thread(new Withdraw(bank));
        thread1.setName("Withdraw");
        thread1.start();
    }
}
