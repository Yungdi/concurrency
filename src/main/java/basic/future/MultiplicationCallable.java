package basic.future;

import java.util.concurrent.Callable;

public class MultiplicationCallable implements Callable<Integer> {
    private final int count;

    public MultiplicationCallable(int count) {
        this.count = count;
    }

    @Override
    public Integer call() throws Exception {
        int i = count * count;
        System.out.println(i);
        return i;
    }
}
