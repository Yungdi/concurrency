package basic;

public class CriticalSectionSample {
    // 두 스레드가 하나의 공유 자원을 사용할 때 발생 문제...

    public static void main(String[] args) {
        // 임계영역: 단 하나의 스레드만 실행할 수 있는 코드 영역
    }

    synchronized void test() {

    }

    void test1() {

        synchronized (this) /* 공유객체 즉 락의 대상 지정 */ {

        }
    }
}
