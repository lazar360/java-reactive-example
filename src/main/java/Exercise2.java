import java.io.IOException;

public class Exercise2 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux and Reactivesources.userFlux

        // Print all numbers in the ReactiveSources.intNumbersFlux stream
        ReactiveSources.intNumbersFlux().subscribe(element -> System.out.println(element));

        // The same for users flux
        ReactiveSources.userFlux().subscribe(user -> System.out.println(user));

        System.out.println("Press a key to end");
        System.in.read();
    }

}
