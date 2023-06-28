package generics;

public class Generics {
    public static void main(String[] args) {
        MyClass<Integer> obj = new MyClass<>(123);

        System.out.println(obj.getAtributo());

        MyClass<String> obj2 = new MyClass<>("texto");

        System.out.println(obj2.getAtributo());
    }
    
}
