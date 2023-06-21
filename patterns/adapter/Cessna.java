package adapter;

public class Cessna implements Monomotor {

    @Override
    public void decolar() {
        System.out.println("Decolando o Cessna");
    }

    @Override
    public void voar() {
        System.out.println("Voando o Cessna");
    }
    
}
