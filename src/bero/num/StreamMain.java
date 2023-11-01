package bero.num;

import java.util.Comparator;
import java.util.List;

public class StreamMain {
    private final List<Integer> numbers;

    public StreamMain(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void main() {
        numbers.stream()
                .filter(x -> x > 0)
                .filter(x -> x % 2 == 0)
                .sorted(Comparator.naturalOrder())
                .forEach(System.out::println);
    }
}
