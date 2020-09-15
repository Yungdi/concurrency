package chapter7;

import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class PrimeGenerator implements Runnable {
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;

    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!cancelled) {
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }

    public void cancel() {
        cancelled = true;
    }

    public synchronized List<BigInteger> get() {
        return new ArrayList<>(primes);
    }

    static List<BigInteger> aSecondOfPrimes() throws InterruptedException {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        new Thread(primeGenerator).start();
        try {
            System.out.println(LocalDateTime.now());
            TimeUnit.SECONDS.sleep(1L);
        } finally {
            System.out.println(LocalDateTime.now());
            primeGenerator.cancel();
        }
        return primeGenerator.get();
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(aSecondOfPrimes());
    }
}
