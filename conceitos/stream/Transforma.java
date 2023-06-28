package stream;

import java.util.Arrays;
import java.util.stream.Stream;

public class Transforma {
    public static void main(String[] args) {
        String frutas[] = new String[]{"apple", "orange", "banana", "pineaple"};

        Stream<String> frutasStream = Arrays.stream(frutas);

        frutasStream
            .map(fruta -> fruta.toUpperCase())
            .forEach(fruta -> System.out.println(fruta) );
    }
}
