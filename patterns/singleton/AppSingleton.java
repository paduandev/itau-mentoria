package singleton;

public class AppSingleton {
    public static void main(String[] args) {
        Highlander highlander1 = Highlander.getInstance();
        Highlander highlander2 = Highlander.getInstance();
        Highlander highlander3 = Highlander.getInstance();
        Highlander highlander4 = Highlander.getInstance();

        System.out.println(highlander1);
        System.out.println(highlander2);
        System.out.println(highlander3);
        System.out.println(highlander4);
    }
}
