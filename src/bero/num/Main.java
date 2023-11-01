package bero.num;

import java.util.Comparator;
import java.util.List;

public class Main {
    private final List<Integer> numbers;

    public Main(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public void main(){
        numbers.sort(Comparator.naturalOrder());
        for (Integer number : numbers) {
            if (number > 0 && number % 2 == 0){
                System.out.println(number);
            }
        }
    }
}
