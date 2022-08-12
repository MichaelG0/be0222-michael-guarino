package m4w4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@NamedQuery(name = "tktBySeller", query = "SELECT t FROM TicketSuper t WHERE t.ts = :ts AND t.issueDate >= :fromDate AND t.issueDate <= :toDate")
public abstract class TicketSuper {
	private Long id;
	private LocalDate issueDate;
	private TicketDealerSuper ts;

	@Id
	@SequenceGenerator(name = "tkt_seq")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "tkt_seq")
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
	}

	@OneToOne
	@JoinColumn(name = "ticket_seller")
	public TicketDealerSuper getTs() {
		return ts;
	}

	public void setTs(TicketDealerSuper ts) {
		this.ts = ts;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [id=" + id + ", issueDate=" + issueDate + ", ts=" + ts + "]";
	}

}
