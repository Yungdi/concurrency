package performance;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class QueueEquality {
    public static void main(String[] args) throws InterruptedException, CloneNotSupportedException {
        BlockingQueue<PidRange> blockingQueue = new LinkedBlockingQueue<>();
        PidRange pidRange = new PidRange();
        blockingQueue.add(pidRange);
        PidRange take = blockingQueue.take();

        System.out.println("원본과 BlockingQueue 데이터 비교");
        System.out.println(pidRange == take);
        System.out.println(pidRange.hashCode() + " == " + take.hashCode());

        System.out.println("원본과 Object.clone 데이터 비교");
        PidRange clonedPidRange = (PidRange) pidRange.clone();
        System.out.println(pidRange == clonedPidRange);
        System.out.println(pidRange.hashCode() + " == " + clonedPidRange.hashCode());
    }
}
