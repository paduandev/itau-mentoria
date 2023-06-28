package lambda;

import java.util.Arrays;
import java.util.List;

/*
     boolean par(int n) {
        return n % 2 == 0;
    }

    n -> n % 2 == 0;
  
 */

public class Lambda {
    public static void main(String[] args) {
        List<Integer> numeros = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        // ForEach
        // for (Integer numero : numeros) {
        //     System.out.println(numero);
        // }

        // numeros.forEach( n -> System.out.println(n) );

        numeros.forEach( n -> {
            if( n % 2 == 0) {
                System.out.println(n);
            }
        });
    }


}
