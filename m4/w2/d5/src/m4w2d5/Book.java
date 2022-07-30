package m4w2d5;

public class Book extends Read {
	private String author;
	private String genre;

	public Book(long isbn, String title, int publicationYear, int numberOfPages, String author, String genre) {
		super(isbn, title, publicationYear, numberOfPages);
		this.author = author;
		this.genre = genre;
	}

	public Book() {
	}

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	@Override
	public String toString() {
		return "Book [isbn=_" + isbn + "_, title=_" + title + "_, publicationYear=_" + publicationYear
				+ "_, numberOfPages=_" + numberOfPages + "_, author=_" + author + "_, genre=_" + genre + "_]";
	}

}
