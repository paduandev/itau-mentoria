package br.empresa.locadora;

public abstract class Movie {
	
	public static final int CHILDRENS = 2;

	public static final int REGULAR = 0;

	public static final int NEW_RELEASE = 1;

	private String _title;

	public Movie(String title) {
		_title = title;
	}

	public static Movie createMovie(String title, int priceCode) {
		if(priceCode == REGULAR) {
			return new Regular(title);
		}
		if(priceCode == NEW_RELEASE) {
			return new NewRelease(title);
		}
		if(priceCode == CHILDRENS) {
			return new Children(title);
		}
		throw new RuntimeException("Tipo de filme incorreto.");
	}

	public String getTitle() {
		return _title;
	};

	public abstract int getFrequentRenterPoints(int daysRented);

	public abstract double getAmount(int daysRented);
}