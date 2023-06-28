package wrapper;

public class Warpper {

    public static void main(String[] args) {
        int valor = 10;

        // Integer inteiro = new Integer(10);
        Integer inteiro = 10; // autoboxing: boxing convertion

        // valor = inteiro.intValue(); // explicita
        valor = inteiro; // auboxing: unboxing convertion

        System.out.println(inteiro);
        System.out.println(valor);

        int numero = Integer.parseInt("123");
        System.out.println(numero);

        int n1 = 7;
        int n2 = 7;

        System.out.println(n1 == n2);

        Integer n3 = 200;
        Integer n4 = 200;

        System.out.println(n3 == n4);
        System.out.println(n3.equals(n4));
    }
}