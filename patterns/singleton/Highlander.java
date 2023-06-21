package singleton;

public class Highlander {
    private static Highlander instance = new Highlander();

    private Highlander() {
        System.out.println("Objeto criado");
    }

    public static Highlander getInstance() {
        // if(instance == null) {
        //     instance = new Highlander();
        // }
        return instance;
    }
}