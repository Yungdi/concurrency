package cucurrency.chapter6.guarded_blocks;

import java.util.Collections;

public class ProducerConsumerExample {
    public static void main(String[] args) {
        Drop drop = new Drop();
        Thread thread = new Thread(new Producer(drop));
        thread.setName("producer");
        thread.start();
        Thread thread1 = new Thread(new Consumer(drop));
        thread1.setName("consumer");
        thread1.start();
    }
}