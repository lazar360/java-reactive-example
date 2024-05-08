import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

public class Exercise5 {
    public static void main(String[] args) {
        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
        ReactiveSources.intNumbersFlux().subscribe(
                number -> System.out.println(number),
                err -> System.out.println(err.getMessage()),
                () -> System.out.println("Complete")
        );

        // Subscribe to a flux using an implementation of BaseSubscriber
        ReactiveSources.intNumbersFlux().subscribe(new MySubscriber<>());

    }
}

class MySubscriber<T> extends BaseSubscriber<T> {

    public void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscription Made");
        request(1); // number of maximum request that can be handled by Subscriber whenever the data ready.
    }

    public void hookOnNext(T val) {
        System.out.println(val + " val received");
        request(1);
    }
    // similarly we can create another hooks for error and completion as they are terminal
    // operation request keyword not likely
}