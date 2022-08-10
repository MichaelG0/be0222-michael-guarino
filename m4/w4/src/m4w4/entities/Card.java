package m4w4.entities;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@Entity
@NamedQuery(name = "elByCardNum", query = "SELECT el FROM Card el WHERE el.cardNumber = :cardNumber")
public class Card {
	private Long cardNumber;
	private LocalDate issueDate;
	private LocalDate expirationDate;
	private SeasonTicket seaTkt;

	@Id
	public Long getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}

	public LocalDate getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(LocalDate issueDate) {
		this.issueDate = issueDate;
		setExpirationDate(issueDate);
	}

	public LocalDate getExpirationDate() {
		return expirationDate;
	}

	private void setExpirationDate(LocalDate issueDate) {
		this.expirationDate = issueDate.plusYears(1);
	}
	
	@OneToOne
	@JoinColumn(name = "season_ticket")
	public SeasonTicket getSeaTkt() {
		return seaTkt;
	}
	
	public void setSeaTkt(SeasonTicket seaTkt) {
		this.seaTkt = seaTkt;
	}
}
