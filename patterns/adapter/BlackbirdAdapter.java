package adapter;

public class BlackbirdAdapter implements Monomotor {
    private Blackbird blackbird;

    public BlackbirdAdapter(Blackbird blackbird) {
        this.blackbird = blackbird;
    }

    @Override
    public void decolar() {
        // criar outros objetos, acionar outros métodos, ...
        blackbird.subir();
    }

    @Override
    public void voar() {
        blackbird.navegar();
    }
    
}
