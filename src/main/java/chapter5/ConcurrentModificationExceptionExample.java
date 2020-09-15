package chapter5;


import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentModificationExceptionExample {
    public static void main(String[] args) {
        // List.of Immutable class
//        List<Integer> integers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        integers.removeIf(integer -> integer % 2 == 0);
        Iterator<Integer> iterator = integers.iterator();
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            if (next % 2 == 0) {
                iterator.remove();
            }
        }
        ConcurrentHashMap<Integer, Integer> map = new ConcurrentHashMap<>();
    }
}
