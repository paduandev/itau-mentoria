package adapter;

public class Piloto {
    private Monomotor monomotor;

    public Piloto(Monomotor monomotor) {
        this.monomotor = monomotor;
    }

    public void pilotar() {
        monomotor.decolar();
        monomotor.voar();
    }
    
}
