package br.empresa;

import br.empresa.locadora.Customer;
import br.empresa.locadora.Movie;
import br.empresa.locadora.Rental;

public final class App {

    public static void main(String[] args) {
        
        Customer client = new Customer("João");
        Movie movie = new Movie("Homem Aranha 2", Movie.NEW_RELEASE);
        Rental rent = new Rental(movie, 2);

        client.addRental(rent);

        String result = client.statement();
        System.out.println(result);
    }
}
