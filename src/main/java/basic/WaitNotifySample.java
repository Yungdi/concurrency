package basic;

public class WaitNotifySample {
    public static void main(String[] args) throws InterruptedException {
        WorkObject shardedObject = new WorkObject();

        ThreadA threadA = new ThreadA(shardedObject);
        ThreadB threadB = new ThreadB(shardedObject);

        threadA.start();
        threadB.start();
        threadA.join();
        threadB.join();
        System.out.println("Completed");
    }
}