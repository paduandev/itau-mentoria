package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/*
 * É possível executar as operações da Stream de forma PARALELA
 */

public class Paralelo {
    public static void main(String[] args) {
        String frutas[] = new String[]{"apple", "orange", "banana", "pineaple"};

        Stream<String> frutasStream = Arrays.stream(frutas);

        List<String> novaLista = frutasStream.parallel().filter( f -> f.endsWith("e") ).collect(Collectors.toList());

        System.out.println(novaLista);
    }
}
