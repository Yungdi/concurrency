package basic.join;

public class NanoJoinEx {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            System.out.println(System.currentTimeMillis());
            try {
                Thread.sleep(1000L);
                System.out.println(System.currentTimeMillis());
            } catch (InterruptedException e) {
            }
        });
        t1.start();
        t1.join(5000L);
        System.out.println(System.currentTimeMillis());
    }
}
