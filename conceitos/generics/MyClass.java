package generics;

public class MyClass<T> {
    private T atributo;

    public MyClass(T obj) {
        atributo = obj;
    }

    public T getAtributo() {
        return atributo;
    }
}
