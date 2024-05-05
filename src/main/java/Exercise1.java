import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Exercise1 {

    public static void main(String[] args) {

        // Use StreamSources

        // Print all numbers in the intNumberStream stream
        System.out.println("Print all numbers in the intNumberStream stream");
        StreamSources.intNumbersStream().forEach(System.out::println);

        // Print numbers from intNumberStream that are less than 5
        System.out.println("Print numbers from intNumberStream that are less than 5");
        StreamSources.intNumbersStream().filter(number -> number<5).forEach(System.out::println);

        // Print the second and third numbers in intNumberStream that's greater than 5 // 8 and 10
        System.out.println("Print the second and third numbers in intNumberStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number>5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        // Print the first number in intNumberStream that's greater than 5
        System.out.println("Print the first number in intNumberStream that's greater than 5");
        StreamSources.intNumbersStream()
                .filter(number -> number > 5)  // Check for numbers greater than 5
                .findFirst()
                .ifPresentOrElse(System.out::println, () -> System.out.println(-1));

        // Print first names of all users in userStream
        System.out.println("Print first names of all users in userStream");
        StreamSources.userStream().forEach(user -> System.out.println(user.getFirstName()));

        // Print first names in userStream for users that have Ids from numberStream
        System.out.println("Print first names in userStream for users that have Ids from numberStream");
        StreamSources.intNumbersStream()
                .flatMap(id -> StreamSources.userStream().filter(user -> user.getId() == id))
                .map(User::getFirstName)
                .forEach(System.out::println);

        // Print first names in userStream for users that have Ids from numberStream
        System.out.println("Print first names in userStream for users that have Ids from numberStream 2 ");
        StreamSources.userStream()
                .filter(user -> StreamSources.intNumbersStream().anyMatch(i -> i == user.getId()))
                .map(User::getFirstName)
                .forEach(System.out::println);

        // Print int
        System.out.println("Print result for i += result - range i = 1 to 10");
        System.out.println(IntStream.range(1,10).sum());

        // Print int
        System.out.println("Print result for i *= result - range i = 1 to 10");
        System.out.println(IntStream.range(1, 4).reduce(1, (a, b) -> a * b));

        // Print list
        List<String> names = new ArrayList<>();
        names.addAll(new ArrayList<>(Arrays.asList("Arold", "Eric", "Fred")));
        System.out.println(names);
        names.add("Arnaud");
        System.out.println(names);

        // Print String
        List<String> listNamesStartWithA = names.stream()
                .filter(namesStartWithA -> namesStartWithA.startsWith("A"))
                .map(String::toUpperCase)
                .toList();
        System.out.println("listNamesStartWithA= " + listNamesStartWithA);
        String namesWithA = names.stream()
                .filter(namesStartWithA -> namesStartWithA.startsWith("A"))
                .collect(Collectors.joining(", "));
        System.out.println("namesWithA= "+ namesWithA);
    }
}
