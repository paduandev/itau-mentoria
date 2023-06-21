package decorator;

public class ChickenDecorator extends Pizza {
    private Pizza pizza;
    private double price = 10;

    public ChickenDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", chicken";
    }

    @Override
    double getPrice() {
        return pizza.getPrice() + price;
    }

}
