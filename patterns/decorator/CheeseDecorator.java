package decorator;

public class CheeseDecorator extends Pizza {
    private Pizza pizza;
    private double price = 5;

    public CheeseDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", cheese";
    }

    @Override
    double getPrice() {
        return pizza.getPrice() + price;
    }
    
}
