package basic.function;

import java.util.function.Consumer;

public class ConsumerAndThenSample {
    public static void main(String[] args) {
        Consumer<String> consumerA = (a) -> System.out.println(a + "hello");
        Consumer<String> consumerB = (a) -> System.out.println(a + "world");
        Consumer<String> consumerAB = consumerA.andThen(consumerB);

        consumerAB.accept("YJ");
    }
}
