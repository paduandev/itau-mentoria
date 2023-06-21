package decorator;

public class MassaFina extends Pizza {
    private double price = 30;

    @Override
    String getDescription() {
        return "Massa fina";
    }

    @Override
    double getPrice() {
        return price;
    }
    
}
