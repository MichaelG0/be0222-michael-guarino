package m4w4.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class TicketSeller {
	private Long id;

	@Id
	@SequenceGenerator(name = "tktseller_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tktseller_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
