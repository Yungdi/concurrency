package chapter7;

import java.math.BigInteger;
import java.util.concurrent.BlockingQueue;

public class PrimeProducer extends Thread {
    private final BlockingQueue<BigInteger> queue;

    public PrimeProducer(BlockingQueue<BigInteger> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!Thread.currentThread().isInterrupted()) {
            try {
                queue.put(p = p.nextProbablePrime());
            } catch (InterruptedException e) {
                System.out.println("종료");
            }
        }
    }

    public void cancel() {
        interrupt();
    }
}
