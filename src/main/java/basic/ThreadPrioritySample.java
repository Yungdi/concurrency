package basic;

public class ThreadPrioritySample {
    public static void main(String[] args) {
        // 멀티스레드는 동시성 or 병렬성으로 실행된다. 그럼 동시성이란? 병렬성이란?
        // 스레드의 개수가 코어수보다 많을 경우 어떤 순서에 의해 동시성으로 실행할 것인가를 결정하는 것이 스레드 스케줄링
        // 자바의 스레드 스케줄링은 우선순위(Priority) 방식과 순환할당(Round-Robin) 방식을 사용
        // 순할 할당 방식은 시간 할당량(Time Slice)을 정해서 하나의 스레드를 정해진 시간만큼 실행하고 다른 스레드를 실행
        // 우선 순위 방식은 우선순위가 높은 스레드가 실행 상태를 더 많이 가지도록 스케줄링
        Thread thread = new Thread();
        thread.setPriority(Thread.MAX_PRIORITY); //10
        thread.setPriority(Thread.MIN_PRIORITY); //1
        thread.setPriority(Thread.NORM_PRIORITY); //5

        for (int i = 1; i <= 10; i++) {
            ThreadPriority threadPriority = new ThreadPriority("thread" + i);
            if (i != 10)
                threadPriority.setPriority(Thread.MIN_PRIORITY);
            else
                threadPriority.setPriority(Thread.MAX_PRIORITY);
            threadPriority.start();
        }
    }
}

class ThreadPriority extends Thread {

    public ThreadPriority(String name) {
        setName(name);
    }

    @Override
    public void run() {
        for (long i = 0; i < 30_000_000_000L; i++) {
        }
        System.out.println(getName());
    }
}
