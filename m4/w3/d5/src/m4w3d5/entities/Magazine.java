package m4w3d5.entities;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Entity
public class Magazine extends Read {
	@Enumerated(EnumType.STRING)
	private Periodicity periodicity;

	public Periodicity getPeriodicity() {
		return periodicity;
	}

	public void setPeriodicity(Periodicity periodicity) {
		this.periodicity = periodicity;
	}

	@Override
	public String toString() {
		return "Magazine [isbn=_" + isbn + "_, title=_" + title + "_, publicationYear=_" + publicationYear
				+ "_, numberOfPages=_" + numberOfPages + "_, periodicity=_" + periodicity + "_]";
	}

}
