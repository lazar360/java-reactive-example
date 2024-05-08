import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class Exercise3 {
    public static void main(String[] args) throws IOException {
        // Use ReactiveSources.intNumbersFlux

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // To put them into a liste and print the list and its size
        List<Integer> numbers = ReactiveSources
                .intNumbersFlux()
                .log()
                .toStream()
                .toList();
        System.out.println("list= " + numbers);
        System.out.println("list.size()= " + numbers.size());
    }
}
