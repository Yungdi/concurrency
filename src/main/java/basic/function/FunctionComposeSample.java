package basic.function;

import java.util.function.Function;

public class FunctionComposeSample {
    public static void main(String[] args) {
        Function<String, String> functionA = (a) -> a + "world";
        Function<Integer, String> functionB = (a) -> a + "hello";
        Function<Integer, String> compose = functionA.compose(functionB);
        System.out.println(compose.apply(5));
    }
}
