package m4w2d5;

public class Magazine extends Read {
	private Periodicity periodicity;

	public Magazine(long isbn, String title, int publicationYear, int numberOfPages, Periodicity periodicity) {
		super(isbn, title, publicationYear, numberOfPages);
		this.periodicity = periodicity;
	}

	public Magazine() {
	}

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	@Override
	public String toString() {
		return "Magazine [periodicity=" + periodicity + ", isbn=" + isbn + ", title=" + title + ", publicationYear="
				+ publicationYear + ", numberOfPages=" + numberOfPages + "]";
	}
	
}
