import java.util.List;

// Listar todas as pessoas
// Listar as 10 primeiras pessoas
// Listar as pessoas que são do Brasil
// Listar as pessoas do Brasil com o nome em Uppercase e suas idades
// Listar as pessoas que são do Brasil, em ordem de nome
// Listar as pessoas que são do Brasil, em ordem de idade
// Contar quantas pessoas tem mais de 45 anos
// Calcular a média de idade das pessoas

// filter() --> seleciona apenas uma parte dos dados. Para isso a expressão lambda deve
//    retornar verdadeiro ou falso.
// verdadeiro para os itens que farão pate do resultado, e falso caso contrário

// map() --> aplicado para transformar os dados de entrada, gerando um novo conjunto de saída

public class Main {
    public static void main(String[] args) {
        List<Pessoa> pessoas = Dados.getPessoas();

        // Listar todas as pessoas
        // pessoas.stream().forEach(System.out::println);

        // Listar as 10 primeiras pessoas
        // pessoas.stream()
        // .limit(10)
        // .forEach(System.out::println);

        // Listar as pessoas que são do Brasil
        // System.out.println("\nPessoas do Brasil:");
        // pessoas.stream()
        // .filter(p -> p.getPais().equals("Brazil"))
        // .forEach(System.out::println);

        // Listar as pessoas do Brasil com o nome em Uppercase e suas idades
        // System.out.println("\nPessoas do Brasil com nome maiusculo e idade:");
        // pessoas.stream()
        // .filter(p -> p.getPais().equals("Brazil"))
        // .map( p -> p.getNome().toUpperCase() + ", " + p.getIdade())
        // .forEach(System.out::println);

        // Listar as pessoas que são do Brasil, em ordem de nome
        // System.out.println("\nPessoas do Brasil em ordem de nome:");
        // pessoas.stream()
        //         .filter(p -> p.getPais().equals("Brazil"))
        //         .sorted((p1, p2) -> p1.getNome().compareTo(p2.getNome()))
        //         .forEach(System.out::println);

        // Listar as pessoas que são do Brasil, em ordem de idade
        // System.out.println("\nPessoas do Brasil em ordem de nome:");
        // pessoas.stream()
        //         .filter(p -> p.getPais().equals("Brazil"))
        //         .sorted()
        //         .forEach(System.out::println);

        // Contar quantas pessoas tem mais de 45 anos
        // System.out.print("\nContar quantas pessoas tem mais de 45 anos: ");

        // long pessoasMaior45 = pessoas.stream()
        //         .filter(p -> p.getIdade() > 45)
        //         .count();

        // System.out.println(pessoasMaior45);

        // Calcular a média de idade das pessoas
        System.out.print("\nCalcular a média de idade das pessoas: ");
        
        Double mediaIdade = pessoas.stream()
            .mapToInt(p -> p.getIdade())
            .average().orElse(0.0);

        System.out.println(mediaIdade);
    }

}
