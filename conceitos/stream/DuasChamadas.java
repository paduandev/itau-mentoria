package stream;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

/*
 * DICA: Não se pode chamar uma mesma Stream 2 vezes
 * É necessário gerar uma nova Stream para cada processamento
 */

public class DuasChamadas {
    public static void main(String[] args) {
        String frutas[] = new String[]{"Apple", "Orange", "Banana", "Pineaple"};

        // Supplier é uma função que aqui não tem parâmetro, mas retorna uma Stream
        // Consumer é uma função que não tem retorno
        Supplier<Stream<String>> frutasSupplierStream = () -> Arrays.stream(frutas);

        // get() --> gera uma nova Stream à partir da função lambda declarada
        frutasSupplierStream.get()
            .map(fruta -> fruta.toUpperCase())
            .forEach(fruta -> System.out.println(fruta) );

        frutasSupplierStream.get()
            .map(fruta -> fruta.toLowerCase())
            .forEach(fruta -> System.out.println(fruta) );
    }
}
