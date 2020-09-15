package chapter3;

public class NotSafeTest {
    public static void main(String[] args) {
        EventSource source = new EventSource();
        ThisEscape thisEscape = new ThisEscape(source);

    }
}
