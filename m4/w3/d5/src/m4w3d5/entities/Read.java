package m4w3d5.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.NamedQuery;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@NamedQuery(name = "elementByIsbn", query = "SELECT el FROM Read el WHERE el.isbn = :isbn ")
@NamedQuery(name = "elementByPublicationYear", query = "SELECT el FROM Read el WHERE el.publicationYear = :publicationYear")
@NamedQuery(name = "bookByAuthor", query = "SELECT el FROM Read el WHERE LOWER(el.author) = LOWER(:author)")
@NamedQuery(name = "elementByTitle", query = "SELECT el FROM Read el WHERE LOWER(el.title) LIKE CONCAT('%', :title, '%')")
public abstract class Read {
	private Long id;

	protected String isbn;
	protected String title;
	protected int publicationYear;
	protected int numberOfPages;

	public String getIsbn() {
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

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setPublicationYear(int publicationYear) {
		this.publicationYear = publicationYear;
	}

	public void setNumberOfPages(int numberOfPages) {
		this.numberOfPages = numberOfPages;
	}

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
