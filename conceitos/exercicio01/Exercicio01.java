package exercicio01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Exercicio01 {
    public static void main(String[] args) {
        int vetor[] = new int[] {51, 21, 13, 74, 35, 6, 71, 18, 9 , 10};

        // exiba os valores pares em ordem crescente

        List<Integer> pares = new ArrayList<>();

        for (int valor : vetor) {
            if (valor % 2 == 0) {
                pares.add(valor);
            }
        }

        Collections.sort(pares);
        System.out.println(pares);
    }
}
