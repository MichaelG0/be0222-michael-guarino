package m4w4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class AuthorizedDealer {
	private Long id;

	@Id
	@GeneratedValue
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Ticket issueTicket() {
		Ticket tkt = new Ticket();
		tkt.setIssueDate(LocalDate.now());
		tkt.setUsed(false);
		return tkt;
	}
	
	public SeasonTicket issueSeasonTicket(Long cardNum, Duration d) {
		SeasonTicket tkt = new SeasonTicket();
		tkt.setIssueDate(LocalDate.now());
		tkt.setUsed(false);
		tkt.setDuration(d);
		return tkt;
	}
}
