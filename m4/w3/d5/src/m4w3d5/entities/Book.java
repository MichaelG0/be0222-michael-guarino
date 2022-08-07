package m4w3d5.entities;

import javax.persistence.Entity;

@Entity
public class Book extends Read {
	private String author;
	private String genre;

	public String getAuthor() {
		return author;
	}

	public String getGenre() {
		return genre;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Book [isbn=_" + isbn + "_, title=_" + title + "_, publicationYear=_" + publicationYear
				+ "_, numberOfPages=_" + numberOfPages + "_, author=_" + author + "_, genre=_" + genre + "_]";
	}

}
