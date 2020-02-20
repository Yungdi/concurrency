package basic.thread_confine;

import java.util.Random;

public class ThreadLocalExample {
    private static ThreadLocal<Integer> connectionHolder =
            ThreadLocal.withInitial(() -> new Random().nextInt(10));

    public static void getRandomInteger() {
        System.out.println(connectionHolder.get());
    }

    public static void main(String[] args) {
        new Thread(ThreadLocalExample::getRandomInteger).start();
        new Thread(ThreadLocalExample::getRandomInteger).start();
        new Thread(ThreadLocalExample::getRandomInteger).start();
        new Thread(ThreadLocalExample::getRandomInteger).start();
    }

}
