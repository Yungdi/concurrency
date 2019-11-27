public class Interrupts {
    // 스레드 종료 시키기
    public static void main(String[] args) {
        String[] inputs = {"a", "b", "c", "d", "e"};
        Runnable runnable = () -> {
            for (int i = 0; i < inputs.length; i++) {
                for (long j = 0; j < 10_000_000_000L; j++) {
                }
                System.out.println(inputs[i]);
                if (Thread.interrupted()) {
                    System.out.println("interrupted");
                    try {
                        throw new InterruptedException();
                    } catch (InterruptedException e) {
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        thread.interrupt();
    }
}
