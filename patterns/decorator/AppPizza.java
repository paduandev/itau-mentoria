package decorator;

public class AppPizza {
    public static void main(String[] args) {
        Pizza pizza = new MassaFina();

        CheeseDecorator pizzaComQueijo = new CheeseDecorator(pizza);

        System.out.println(pizzaComQueijo.getDescription() + " R$ " + pizzaComQueijo.getPrice());

        CornDecorator pizzaComQueijoeMilho = new CornDecorator(pizzaComQueijo);

        System.out.println(pizzaComQueijoeMilho.getDescription() + " R$ " + pizzaComQueijoeMilho.getPrice());

        Pizza pizza2 = new CheeseDecorator( new ChickenDecorator( new MassaFina()));

        System.out.println(pizza2.getDescription() + " R$ " + pizza2.getPrice());
    }
}
