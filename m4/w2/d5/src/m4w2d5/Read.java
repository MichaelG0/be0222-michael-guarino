package m4w2d5;

public abstract class Read {
	protected long isbn;
	protected String title;
	protected int publicationYear;
	protected int numberOfPages;

	public Read(long isbn, String title, int publicationYear, int numberOfPages) {
		this.isbn = isbn;
		this.title = title;
		this.publicationYear = publicationYear;
		this.numberOfPages = numberOfPages;
	}

	public Read() {
	}

	public long getIsbn() {
		return isbn;
	}

	public String getTitle() {
		return title;
	}

	public int getPublicationYear() {
		return publicationYear;
	}

	public int getNumberOfPages() {
		return numberOfPages;
	}

}
