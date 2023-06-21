package decorator;

public class CornDecorator extends Pizza {
    private Pizza pizza;
    private double price = 10;

    public CornDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    String getDescription() {
        return pizza.getDescription() + ", corn";
    }

    @Override
    double getPrice() {
        return pizza.getPrice() + price;
    }
    
}
