package basic.group;

import java.util.Map;
import java.util.Set;

public class ThreadGroupSample {
    public static void main(String[] args) {
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        String threadGroupName = threadGroup.getName();
        System.out.println(threadGroupName);
        new Thread(() -> {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
        Set<Thread> threads = allStackTraces.keySet();
        threads.forEach(thread ->
                System.out.println("Name: " + thread.getName() + ", isDaemon: " + thread.isDaemon() + ", Group: " + thread.getThreadGroup().getName()));
    }
}