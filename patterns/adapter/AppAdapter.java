package adapter;

public class AppAdapter {
    public static void main(String[] args) {
        Cessna cessna = new Cessna();
        Piloto piloto = new Piloto(cessna);

        piloto.pilotar();

        Blackbird blackbird = new Blackbird();

        BlackbirdAdapter adapter = new BlackbirdAdapter(blackbird);

        Piloto piloto2 = new Piloto(adapter);

        piloto2.pilotar();
    }
}
