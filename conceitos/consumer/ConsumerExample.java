package consumer;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerExample {
    public static void main(String[] args) {
        List<String> letras = Arrays.asList("a", "b", "c", "d");

        Consumer<String> action = s -> System.out.println(s.toUpperCase());

        letras.forEach(action);
    }
}
