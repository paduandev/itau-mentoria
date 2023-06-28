package stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Exemplos {
    public static void main(String[] args) {
        List<Integer> listaNumeros = Arrays.asList(51, 21, 13, 74, 35, 6, 71, 18, 9, 10);

        // listaNumeros.stream().forEach( n -> System.out.println(n) );
        // Method Reference
        // listaNumeros.stream().forEach(System.out::println);

        // exibir somente os numeros pares da lista
        // listaNumeros.stream()
        // .filter( n -> n % 2 == 0)
        // .forEach(System.out::println);

        // exibir somente os numeros pares da lista em ordem crescente
        // listaNumeros.stream().filter( n -> n % 2 ==
        // 0).sorted().forEach(System.out::println);

        // List<Integer> listaPares = listaNumeros.stream().filter(n -> n % 2 == 0).sorted().collect(Collectors.toList());
        // System.out.println(listaPares);

        // Todos os números da lista multiplicados por 2
        // List<Integer> listaMultiplicada = listaNumeros.stream().map(n -> n * 2).collect(Collectors.toList());
        // System.out.println(listaMultiplicada);

        // quantos números impares existem na lista
        long qtdeImpares = listaNumeros.stream().filter( n -> n % 2 != 0).count();
        System.out.println("impares: " + qtdeImpares);
    }
}
