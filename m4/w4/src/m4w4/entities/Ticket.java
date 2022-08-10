package m4w4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class Ticket {
	private Long id;
	protected LocalDate issueDate = LocalDate.now();
	private boolean used = false;
	private TicketSeller ts;

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

	public boolean isUsed() {
		return used;
	}

	public void setUsed(boolean used) {
		this.used = used;
	}
	
	@ManyToOne
	@JoinColumn(name = "ticket_seller")
	public TicketSeller getTs() {
		return ts;
	}
	
	public void setTs(TicketSeller ts) {
		this.ts = ts;
	}

}
