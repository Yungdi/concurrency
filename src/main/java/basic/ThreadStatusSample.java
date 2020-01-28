package basic;

public class ThreadStatusSample {
    /**
     * 스레드 객체를 생성하고, start() 메소드를 호출하면 곧바로 스레드가 실행되는 것처럼 보이지만 사실은 실행대기상태
     * 일시정지상태: wating, timed_wating, blocked
     */

    public static void main(String[] args) {
        Thread thread = new Thread(); // NEW
        thread.start(); // RUNNABLE -> RUNNING
        // 스레드 스케줄링
    }
}
