package br.empresa.locadora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCustomer {
	
	Customer client;

	@BeforeEach
	protected void setUp() throws Exception {
		client = new Customer("João");
	}
	
	@Test
	public void testNameCreation(){
		String result = client.statement();
		assertContain(result,"Rental Record for João");
	}

	@Test
	public void testOneRegularOneDay(){
		rentMovie("Indiana Jones",Movie.REGULAR,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 2.0");
		assertContain(result,"You earned 1 frequent renter points");
	}

	@Test
	public void testOneRegularTreeDays(){
		rentMovie("Indiana Jones",Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.5");
		assertContain(result,"You earned 1 frequent renter points");
	}

	@Test
	public void testOneChildrensOneDay(){
		rentMovie("Procurando Nemo",Movie.CHILDRENS,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 1.5");
		assertContain(result,"You earned 1 frequent renter points");
	}

	@Test
	public void testOneChildrensFiveDays(){
		rentMovie("Procurando Nemo",Movie.CHILDRENS,5);
		String result = client.statement();
		assertContain(result,"Amount owed is 4.5");
		assertContain(result,"You earned 1 frequent renter points");
	}

	@Test
	public void testOneNewReleaseOneDay(){
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,1);
		String result = client.statement();
		assertContain(result,"Amount owed is 3.0");
		assertContain(result,"You earned 1 frequent renter points");
	}

	@Test
	public void testOneNewReleaseTreeDays(){
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 9.0");
		assertContain(result,"You earned 2 frequent renter points");
	}

	@Test
	public void testManyRents(){
		rentMovie("Homem Aranha 2",Movie.NEW_RELEASE,2);
		rentMovie("Troia",Movie.NEW_RELEASE,3);
		rentMovie("Procurando Nemo",Movie.CHILDRENS,3);
		rentMovie("Indiana Jones",Movie.REGULAR,2);
		rentMovie("Rei Leão",Movie.CHILDRENS,4);
		rentMovie("E o vento levou...",Movie.REGULAR,3);
		String result = client.statement();
		assertContain(result,"Amount owed is 25.0");
		assertContain(result,"You earned 8 frequent renter points");
	}


	private void rentMovie(String title, int type, int days) {
		Movie movie = Movie.createMovie(title,type);
		Rental rent = new Rental(movie,days);
		client.addRental(rent);
	}


	private void assertContain(String result, String content) {
		assertTrue(result.indexOf(content)>=0);
	}
	
}
